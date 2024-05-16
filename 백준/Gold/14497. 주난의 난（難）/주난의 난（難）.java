import java.io.*;
import java.util.*;
public class Main {
    static int N, M, count = 0, jn_y, jn_x, choco_y, choco_x;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] visited;

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        jn_y = Integer.parseInt(st.nextToken());
        jn_x = Integer.parseInt(st.nextToken());
        choco_y = Integer.parseInt(st.nextToken());
        choco_x = Integer.parseInt(st.nextToken());
        map = new char[N+2][M+2];
        visited = new boolean[N+2][M+2];
        for(int i = 1; i <= N; i++){
            String line = br.readLine();
            for(int j = 0; j < line.length(); j++){
                map[i][j+1] = line.charAt(j);
            }
        }
    }
    static void solution() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1000 * jn_y + jn_x);
        visited[jn_y][jn_x] = true;
        while(map[choco_y][choco_x] != '0'){
            count++;
            Queue<Integer> temp = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                int current = queue.poll();
                int x = current % 1000;
                int y = current / 1000;
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if (nx <= 0 || nx > M || ny <= 0 || ny > N || visited[ny][nx]) continue;
                    visited[ny][nx] = true;
                    if(map[ny][nx] != '0'){
                        map[ny][nx] = '0';
                        temp.offer(ny * 1000 + nx);
                    }
                    else
                        queue.offer(ny * 1000 + nx);
                }
            }
            queue = temp;
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(count);
    }
}