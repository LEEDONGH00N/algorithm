import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int m;static int n; static int k; static int answer; static int count = 1;
    static int[] dir = {1, 0, -1, 0, 0, -1, 0, 1};
    static void DFS(int a, int b, int[][] check){
        if(check[a][b] == 1){
            check[a][b] = 0;
            for(int i = 0; i < 4; i++) {
                if(check[a + dir[i * 2]][b + dir[i * 2 + 1]] == 1)
                    DFS(a + dir[i * 2], b + dir[i * 2 + 1], check);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            answer = 0;
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            int[][] check = new int[m+2][n+2];
            for(int j = 0; j < k; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                check[a+1][b+1] = 1;
            }
            for(int a = 1; a <= m; a++){
                for(int b = 1; b <= n; b++){
                    if(check[a][b] == 1){
                        DFS(a, b, check);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
