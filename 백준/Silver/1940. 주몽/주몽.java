import java.util.*;
import java.io.*;

public class Main {

    static int N, M, answer = 0;
    static int[] nums = new int[16000000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        solve();
        System.out.println(answer);
    }

    static void solve(){
        for(int i = 1; i <= M/2; i++){
            if(nums[i] == 1 && nums[M - i] == 1 && i != M - i){
                answer++;
            }
        }
    }

    static void input(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[num] = 1;
        }
    }
}
