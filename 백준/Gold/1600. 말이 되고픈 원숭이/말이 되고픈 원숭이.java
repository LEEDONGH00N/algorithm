import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = {0, 0, -1, 1, -1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dx = {-1, 1, 0, 0, -2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[M][N];
        boolean[][][] visited = new boolean[M][N][K+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0});
        visited[0][0][0] = true;
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cur = q.poll();
                int y = cur[0], x = cur[1], cur_count = cur[2];
                if(y == M - 1 && x == N - 1) {
                    System.out.println(level);
                    return;
                }
                for (int i = 0; i < 12; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(i >= 4 && cur_count >= K) continue;
                    int nk = i >= 4 ? cur_count + 1 : cur_count;
                    if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[ny][nx] == 1 || visited[ny][nx][nk]) continue;
                    visited[ny][nx][nk] = true;
                    q.offer(new int[]{ny, nx, nk});
                }
            }
            level++;
        }
        System.out.println(-1);
    }
}
