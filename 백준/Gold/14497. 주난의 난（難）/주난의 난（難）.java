import java.io.*;
import java.util.*;
class Dot{
    int y, x;

    public Dot(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
public class Main {
    static int N, M;
    static int jn_y, jn_x;
    static int choco_y, choco_x;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
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
        for(int i = 1; i <= N; i++){
            String line = br.readLine();
            for(int j = 0; j < line.length(); j++){
                map[i][j+1] = line.charAt(j);
            }
        }
    }
    static boolean solution() {
        Set<Dot> dots = new HashSet<>();
        Queue<Dot> queue = new ArrayDeque<>();
        queue.offer(new Dot(jn_y, jn_x));
        visited[jn_y][jn_x] = true;
        while (!queue.isEmpty()) {
            Dot dot = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dot.x + dx[i];
                int ny = dot.y + dy[i];
                if (nx <= 0 || nx > M || ny <= 0 || ny > N || visited[ny][nx]) continue;
                if (map[ny][nx] == '1') {
                    dots.add(new Dot(ny, nx));
                    visited[ny][nx] = true;
                    continue;
                }
                else if (map[ny][nx] == '#') {
                    map[ny][nx] = 'X';
                    return true;
                }
                queue.offer(new Dot(ny, nx));
                visited[ny][nx] = true;
            }
        }
        for (Dot dot : dots) {
            map[dot.y][dot.x] = '0';
        }
        return false;
    }
//    static void printMap(){
//        for(int i = 1; i <= N; i++){
//            for(int j = 1; j <= M; j++){
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
    public static void main(String[] args) throws IOException {
        input();
        int count = 0;
        while(true){
            count++;
            visited = new boolean[N+2][M+2];
            if(solution()) {
                System.out.println(count);
                break;
            }
        }

    }
}