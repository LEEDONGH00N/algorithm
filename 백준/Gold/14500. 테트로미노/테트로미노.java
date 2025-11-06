import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] a;
    static boolean[][] visited;
    static int answer = 0, max = 0;
    static final int[] dx = {1,-1,0,0};
    static final int[] dy = {0,0,1,-1};

    static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            answer = Math.max(answer, sum);
            return;
        }
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;
            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1, sum + a[nx][ny]);
            visited[nx][ny] = false;
        }
    }

    static void checkT(int x, int y) {
        int center = a[x][y];
        // ㅗ
        if (x-1>=0 && y-1>=0 && y+1<M)
            answer = Math.max(answer, center + a[x-1][y] + a[x][y-1] + a[x][y+1]);
        // ㅜ
        if (x+1<N && y-1>=0 && y+1<M)
            answer = Math.max(answer, center + a[x+1][y] + a[x][y-1] + a[x][y+1]);
        // ㅏ
        if (x-1>=0 && x+1<N && y+1<M)
            answer = Math.max(answer, center + a[x-1][y] + a[x+1][y] + a[x][y+1]);
        // ㅓ
        if (x-1>=0 && x+1<N && y-1>=0)
            answer = Math.max(answer, center + a[x-1][y] + a[x+1][y] + a[x][y-1]);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        a = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, a[i][j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, a[i][j]);
                visited[i][j] = false;
                checkT(i, j);
            }
        }

        System.out.println(answer);
    }
}