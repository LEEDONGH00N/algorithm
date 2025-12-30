import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dp = new int[n + 1];
        dp[0] = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(i == 1) dp[1] = num;
            else dp[i] = num + dp[i - 1];
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(dp[end] - dp[start -1]);
        }
    }
}