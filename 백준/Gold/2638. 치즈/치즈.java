import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Dot{
    int x;
    int y;
    public Dot(int y, int x){
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N;
    static int M;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    static int[][] cheese;
    static int[][] visited;
    static int[][] airContactCount;
    static List<Dot> side;
    static void bfs() {
        Queue<Dot> queue = new LinkedList<>();
        queue.offer(new Dot(0, 0));
        visited[0][0] = 1;

        while (!queue.isEmpty()) {
            Dot dot = queue.poll();
            for (int d = 0; d < 4; d++) {
                int ny = dot.y + dy[d];
                int nx = dot.x + dx[d];
                if (ny < 0 || nx < 0 || ny >= N || nx >= M) continue;
                if (cheese[ny][nx] == 1) {
                    airContactCount[ny][nx]++;
                    if (airContactCount[ny][nx] == 2) {
                        side.add(new Dot(ny, nx));
                    }
                } else if (cheese[ny][nx] == 0 && visited[ny][nx] == 0) {
                    visited[ny][nx] = 1;
                    queue.offer(new Dot(ny, nx));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int size = 0, time = 0;
        cheese = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int isCheese = Integer.parseInt(st.nextToken());
                cheese[i][j] = isCheese;
                if(isCheese == 1) {
                    size++;
                }
            }
        }

        while(size > 0){
            visited = new int[N][M];
            airContactCount = new int[N][M];
            side = new ArrayList<>();
            bfs();
            time++;
            for(Dot dot : side) {
                cheese[dot.y][dot.x] = 0;
            }
            size -= side.size();
        }
        System.out.println(time);
    }
}