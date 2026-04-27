import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] map;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        // bfs
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0], x = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || ny < 0 || ny >= N || nx >= M) continue;
                if(map[ny][nx] == 0 || visited[ny][nx] > 0) continue;
                visited[ny][nx] = visited[y][x] + 1;
                queue.offer(new int[]{ny, nx});
            }
        }
        System.out.println(visited[N-1][M-1]);
    }

}