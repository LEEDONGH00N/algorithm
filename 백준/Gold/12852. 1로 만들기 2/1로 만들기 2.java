import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        int N = Integer.parseInt(line);

        // 1. dp 배열을 -1로 초기화 (방문 여부 확인용)
        int[][] dp = new int[N + 1][2];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = -1; 
        }

        // 2. 시작점인 1의 연산 횟수는 0으로 설정
        dp[1][0] = 0;

        for (int i = 1; i <= N; i++) {
            // 현재 숫자 i가 도달 가능한 숫자인 경우에만 다음으로 전파
            if (dp[i][0] == -1) continue;

            // 3배 하기
            if ((long)i * 3 <= N) {
                int next = i * 3;
                if (dp[next][0] == -1 || dp[i][0] + 1 < dp[next][0]) {
                    dp[next][0] = dp[i][0] + 1;
                    dp[next][1] = i;
                }
            }
            // 2배 하기
            if ((long)i * 2 <= N) {
                int next = i * 2;
                if (dp[next][0] == -1 || dp[i][0] + 1 < dp[next][0]) {
                    dp[next][0] = dp[i][0] + 1;
                    dp[next][1] = i;
                }
            }
            // 1 더하기
            if (i + 1 <= N) {
                int next = i + 1;
                if (dp[next][0] == -1 || dp[i][0] + 1 < dp[next][0]) {
                    dp[next][0] = dp[i][0] + 1;
                    dp[next][1] = i;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        // 첫 번째 줄: 최소 연산 횟수
        sb.append(dp[N][0]).append("\n");

        // 두 번째 줄: 경로 추적 (N부터 1까지)
        int current = N;
        while (current >= 1) {
            sb.append(current).append(" ");
            if (current == 1) break; // 1에 도달하면 종료
            current = dp[current][1];
            
            // 만약 경로가 잘못되어 0으로 가면 무한 루프 방지를 위해 탈출
            if (current == 0) break;
        }

        System.out.println(sb.toString());
    }
}