import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][N + 1];
            for (int r = 0; r < 2; r++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 1; i <= N; i++) {
                    sticker[r][i] = Integer.parseInt(st.nextToken());
                }
            }

            // dp[i][0] = i열에서 안 뗌
            // dp[i][1] = i열에서 위(행0) 뗌
            // dp[i][2] = i열에서 아래(행1) 뗌
            int[][] dp = new int[N + 1][3];
            dp[1][1] = sticker[0][1];
            dp[1][2] = sticker[1][1];

            for (int i = 2; i <= N; i++) {
                dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + sticker[0][i];
                dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + sticker[1][i];
            }

            sb.append(Math.max(dp[N][0], Math.max(dp[N][1], dp[N][2]))).append('\n');
        }
        System.out.print(sb);
    }
}
