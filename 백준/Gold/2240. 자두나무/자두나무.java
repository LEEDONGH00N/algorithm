import java.io.*;
import java.util.*;

public class Main {

    static int T, W, answer = 0;
    static int[] plum;
    static int[][] dp;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        plum = new int[T+1];
        dp = new int[T+1][W+1];
        for(int i = 1; i <= T; i++){
            plum[i] = Integer.parseInt(br.readLine());
        }
    }

    static void solution(){

        //w가 짝수이면 1번 나무에, 홀수면 2번 나무에 있다는 걸 뜻함

        for(int t = 1; t <= T; t++){
            int tree = plum[t];
            for(int w = 0; w <= W; w++){
                // 자리를 옮긴 적이 없음
                // 현재 1번 나무에 있음
                if(w == 0){
                    if(tree == 1){
                        dp[t][w] = dp[t-1][w] + 1;
                    }
                    else{
                        dp[t][w] = dp[t-1][w];
                    }
                    continue;
                }

                //이동을 함
                //현재 2번 나무에 있음
                if(w % 2 != 0){
                    if(tree == 1){
                        dp[t][w] = Math.max(dp[t-1][w], dp[t-1][w-1] + 1);
                    }
                    else{
                        dp[t][w] = Math.max(dp[t-1][w] + 1, dp[t-1][w-1]);
                    }
                }

                //현재 1번 나무에 있음
                else {
                    if(tree == 1){
                        dp[t][w] = Math.max(dp[t-1][w] + 1, dp[t-1][w-1]);
                    }
                    else{
                        dp[t][w] = Math.max(dp[t-1][w], dp[t-1][w-1] + 1);
                    }
                }
                answer = Math.max(answer, dp[t][w]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(answer);
    }
}