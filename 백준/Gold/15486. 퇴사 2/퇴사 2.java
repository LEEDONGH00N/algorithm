import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] schedules = new int[N+2][2];
        int max = -1;
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            schedules[i][0] = Integer.parseInt(st.nextToken());
            schedules[i][1] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N+2];
        for(int i = 1; i <= N; i++) {
            dp[i+1] = Math.max(dp[i+1], dp[i]);
            if(i + schedules[i][0] > N + 1) continue;
            if(dp[i + schedules[i][0]] < dp[i] + schedules[i][1]) {
                dp[i + schedules[i][0]] = dp[i] + schedules[i][1];
            }
        }
        for(int i = 1; i <= N+1; i++){
            if(max < dp[i]) max = dp[i];
        }

        System.out.println(max);
    }
}