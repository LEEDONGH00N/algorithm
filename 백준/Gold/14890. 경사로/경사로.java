import java.io.*;
import java.util.*;

public class Main {

    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        input();
        int answer = 0;

        // 가로
        for (int i = 0; i < N; i++) {
            int[] line = new int[N];
            for (int j = 0; j < N; j++) {
                line[j] = map[i][j];
            }
            if (canGo(line)) answer++;
        }

        // 세로
        for (int j = 0; j < N; j++) {
            int[] line = new int[N];
            for (int i = 0; i < N; i++) {
                line[i] = map[i][j];
            }
            if (canGo(line)) answer++;
        }

        System.out.println(answer);
    }

    static boolean canGo(int[] h) {
        boolean[] used = new boolean[N]; // 경사로 사용 여부

        for (int i = 0; i < N - 1; i++) {
            int diff = h[i + 1] - h[i];
            if (diff == 0) continue;
            if (Math.abs(diff) > 1) return false;
            if (diff == 1) {
                int height = h[i];
                for (int j = i; j > i - L; j--) {
                    if (j < 0) return false;        
                    if (h[j] != height) return false; 
                    if (used[j]) return false;
                    used[j] = true;
                }
            }
            else if (diff == -1) {
                int height = h[i + 1];
                for (int j = i + 1; j <= i + L; j++) {
                    if (j >= N) return false;        
                    if (h[j] != height) return false;
                    if (used[j]) return false;      
                    used[j] = true;
                }
            }
        }

        return true;
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}