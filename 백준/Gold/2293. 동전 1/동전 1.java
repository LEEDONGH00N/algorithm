import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coin = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        // dp[i][j] = i번째 동전까지 사용하여 합계 j를 만드는 경우의 수
        int[][] dp = new int[N + 1][K + 1];
        dp[0][0] = 1; // 합계 0을 만드는 방법: 아무것도 안 쓰기 1가지

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = dp[i - 1][j];                    // 이 동전 안 씀
                if (j >= coin[i]) {
                    dp[i][j] += dp[i][j - coin[i]];          // 이 동전 또 씀
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
