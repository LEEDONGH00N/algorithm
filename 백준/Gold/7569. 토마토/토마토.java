import java.io.*;
import java.util.*;

public class Main {

    static int N, M, H, day = 0;
    static int raw_count = 0, ripe_count = 0, blank_count = 0;
    static int[] dy = new int[]{-1, 0, 1, 0};
    static int[] dx = new int[]{0, -1, 0, 1};
    static int[] dz = new int[]{1, -1};
    static boolean[][][] visited;
    static int[][][] box;
    static Queue<int[]> queue = new ArrayDeque<>();

    static void bfs() {
        while (!queue.isEmpty()) {
            int size = queue.size(); // 현재 레벨 노드 수
            for (int s = 0; s < size; s++) {
                int[] current = queue.poll();
                int z = current[0];
                int y = current[1];
                int x = current[2];
                for (int i = 0; i < 2; i++){ // 위 아래
                    int nz = z + dz[i];
                    if(nz >= H || nz < 0 || visited[nz][y][x]) continue;
                    if(box[nz][y][x] == 0){
                        box[nz][y][x] = 1;
                        raw_count--;
                        queue.offer(new int[]{nz, y, x});
                    }
                    visited[nz][y][x] = true;
                }
                for (int i = 0; i < 4; i++) { // 상하죄우
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    if (ny < 0 || ny >= M || nx < 0 || nx >= N || visited[z][ny][nx]) continue;
                    if (box[z][ny][nx] == 0) {
                        box[z][ny][nx] = 1;
                        raw_count--;
                        queue.offer(new int[]{z, ny, nx});
                    }
                    visited[z][ny][nx] = true;
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
        H = Integer.parseInt(st.nextToken());
        box = new int[H][M][N];
        visited = new boolean[H][M][N];
        for (int k = 0; k < H; k++) {
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int current = Integer.parseInt(st.nextToken());
                    box[k][i][j] = current;
                    if(current == 0){
                        raw_count++;
                    }
                    else if (current == 1){
                        ripe_count++;
                        queue.offer(new int[]{k, i, j});
                        visited[k][i][j] = true;
                    }
                    else{
                        blank_count++;
                    }
                }
            }
        }

        if(ripe_count == N * M - blank_count){
            System.out.println("0");
            return;
        }
        bfs();
        if(raw_count == 0){
            System.out.println(day - 1);
        }
        else {
            System.out.println("-1");
        }

    }
}