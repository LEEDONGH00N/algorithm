import java.io.*;
import java.util.*;

public class Main {

    static int N, M, day = 0;
    static int raw_count = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int[][] box;
    static Queue<int[]> queue = new ArrayDeque<>();

    static void bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] current = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = current[0] + dy[i];
                    int nx = current[1] + dx[i];
                    if (ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
                    if (box[ny][nx] == 0) {
                        box[ny][nx] = 1;
                        raw_count--;
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }
            day++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        box = new int[M][N];

        int ripe_count = 0, blank_count = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                box[i][j] = tomato;
                if (tomato == 0) {
                    raw_count++;
                } else if (tomato == 1) {
                    ripe_count++;
                    queue.offer(new int[]{i, j});
                } else {
                    blank_count++;
                }
            }
        }

        if (ripe_count == N * M - blank_count) {
            System.out.println(0);
            return;
        }

        bfs();

        if (raw_count == 0) {
            System.out.println(day - 1);
        } else {
            System.out.println(-1);
        }
    }
}