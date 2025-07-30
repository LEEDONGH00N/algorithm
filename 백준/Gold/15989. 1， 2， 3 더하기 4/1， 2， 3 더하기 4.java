import java.io.*;

public class Main {
    static final int MAX = 10000;
    static long[] dp = new long[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        dp[0] = 1;
        for (int i = 1; i <= 3; i++) {
            for (int j = i; j <= MAX; j++) {
                dp[j] = dp[j] + dp[j - i];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        System.out.print(sb);
    }
}