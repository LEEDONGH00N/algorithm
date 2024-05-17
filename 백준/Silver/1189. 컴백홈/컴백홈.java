import java.io.*;
import java.util.*;
public class Main {
    static int R, C, K, count = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static boolean[][] visited;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }
    }

    static void solution(int y, int x, int distance){
        if(y == 0 && x == C-1 && distance == K){
            count++;
            return;
        }
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= R || nx >= C || visited[ny][nx] || map[ny][nx] == 'T') continue;
            visited[ny][nx] = true;
            solution(ny, nx, distance + 1);
            visited[ny][nx] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        visited[R-1][0] = true;
        solution(R-1, 0, 1);
        System.out.println(count);
    }
}