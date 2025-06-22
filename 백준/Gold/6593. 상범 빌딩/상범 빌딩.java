import java.io.*;
import java.util.*;

public class Main {

    static boolean canEscape;
    static int L, R, C, time = 0;
    static int start_z, start_y, start_x;
    static int end_z, end_y, end_x;

    static Queue<int[]> queue;
    static int[][] dir = {
            {1, 0, 0},
            {-1, 0, 0},
            {0, -1, 0},
            {0, 1, 0},
            {0, 0, -1},
            {0, 0, 1}
    };
    static int[][][] building;

    static void bfs() {
        queue = new ArrayDeque<>();
        queue.offer(new int[]{start_z, start_y, start_x});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int[] current = queue.poll();
                int z = current[0], y = current[1], x = current[2];
                if(z == end_z && y == end_y && x == end_x) {
                    canEscape = true;
                    return;
                }
                for (int[] dir : dir) {
                    int nz = z + dir[0];
                    int ny = y + dir[1];
                    int nx = x + dir[2];
                    if (nz < 0 || nz >= L || ny < 0 || ny >=R || nx < 0 || nx >= C || building[nz][ny][nx] == 1) continue;
                    building[nz][ny][nx] = 1;
                    queue.offer(new int[]{nz, ny, nx});
                }
            }
            time++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            String line = br.readLine();
            if (line == null || line.trim().isEmpty()) continue;  // 빈 줄 무시
            st = new StringTokenizer(line);
            L = Integer.parseInt(st.nextToken());R = Integer.parseInt(st.nextToken());C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;
            building = new int[L][R][C];
            for (int k = 0; k < L; k++) {
                for (int i = 0; i < R; i++) {
                    String current = br.readLine();
                    while (current.isEmpty()) current = br.readLine();
                    for (int j = 0; j < C; j++) {
                        char c = current.charAt(j);
                        if (c == 'S') {
                            start_z = k; start_y = i; start_x = j;
                        } else if (c == 'E') {
                            end_z = k; end_y = i; end_x = j;
                        } else if (c == '#') {
                            building[k][i][j] = 1;
                        } else if (c == '.') {
                            building[k][i][j] = 0;
                        }
                    }
                }
                if (k != L - 1) {
                    br.readLine();
                }
            }
            time = 0; canEscape = false;
            bfs();
            if (!canEscape) System.out.println("Trapped!");
            else System.out.println("Escaped in " + time + " minute(s).");
        }

    }
}