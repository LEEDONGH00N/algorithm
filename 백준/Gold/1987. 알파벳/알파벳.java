import java.io.*;
import java.util.*;
public class Main {
    static int R, C;
    static int path = 0;
    static char[][] map;
    static boolean[] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R + 2][C + 2];
        visited = new boolean[26];
        for(int i = 1; i <= R; i++){
            String line = br.readLine();
            for(int j = 1; j <= C; j++){
                map[i][j] = line.charAt(j-1);
            }
        }
    }
    static void solution(int cnt, int y, int x) {
        path = Math.max(path, cnt);
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny == 0 || ny > R || nx == 0 || nx > C) continue;
            int next = map[ny][nx] - 'A';
            if(!visited[next]){
                visited[next] = true;
                solution(cnt + 1, ny, nx);
                visited[next] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        input();
        visited[map[1][1] - 'A'] = true;
        solution(1, 1, 1);
        
        StringBuilder sb = new StringBuilder();
        sb.append(path);
        System.out.println(sb);
    }
}