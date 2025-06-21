import java.io.*;
import java.util.*;

public class Main {

    static int N, M, H, day = 0;
    static int raw_count = 0;
    static Queue<int[]> queue = new ArrayDeque<>();
    static int[][] dir = {
            {1, 0, 0},
            {-1, 0, 0},
            {0, -1, 0},
            {0, 1, 0},
            {0, 0, -1},
            {0, 0, 1}
    };
    static int[][][] box;

    static void bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] current = queue.poll();
                int z = current[0], y = current[1], x = current[2];
                for(int[] dir : dir) {
                    int nz = z + dir[0];
                    int ny = y + dir[1];
                    int nx = x + dir[2];
                    if (nz < 0 || nz >= H || ny < 0 || ny >= M || nx < 0 || nx >= N) continue;
                    if (box[nz][ny][nx] == 0) {
                        box[nz][ny][nx] = 1;
                        raw_count--;
                        queue.offer(new int[]{nz, ny, nx});
                    }
                }
            }
            day++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        box = new int[H][M][N];

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int current = Integer.parseInt(st.nextToken());
                    box[k][i][j] = current;
                    if (current == 0) {
                        raw_count++;
                    } else if (current == 1) {
                        queue.offer(new int[]{k, i, j});
                    }
                }
            }
        }

        if (raw_count == 0) {
            System.out.println("0");
            return;
        }

        bfs();

        if (raw_count == 0) {
            System.out.println(day - 1);
        } else {
            System.out.println("-1");
        }
    }
}