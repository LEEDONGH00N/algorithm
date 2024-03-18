import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Dot{
    int x;
    int y;
    public Dot(int y, int x) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int N;
    static int M;
    static int count = 0;
    static int[] wall = new int[3];
    static int[] dy = {-1, 1, 0 ,0};
    static int[] dx = {0 ,0, 1, -1};
    static int[][] mapCopy;
    static int[][] map;
    static int[][] visited;
    static List<Dot> virus;
    static List<Dot> zeros;
    static int result = Integer.MIN_VALUE;
    static void bfs(int i, int j){
        Queue<Dot> queue = new LinkedList<>();
        queue.add(new Dot(i, j));
        while (!queue.isEmpty()){
            Dot dot = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = dot.x + dx[d];
                int ny = dot.y + dy[d];
                if (ny < 0 || nx < 0 || nx >= M || ny >= N) continue;
                if (visited[ny][nx] == 1 || map[ny][nx] == 1 || map[ny][nx] == 2) continue;
                map[ny][nx] = 2;
                queue.add(new Dot(ny, nx));
                visited[ny][nx] = 1;
            }
        }
    }
    static void countZero(){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0)
                    count++;
            }
        }
    }
    static void makeWall(){
        for(int t = 0; t < 3; t++){
            int y = zeros.get(wall[t]).y;
            int x = zeros.get(wall[t]).x;
            map[y][x] = 1;
        }
    }

    static void copyMap(){
        for(int i = 0; i < N; i++){
            map[i] = Arrays.copyOf(mapCopy[i], M);
        }
    }
    static void copyMapCopy(){
        for(int i = 0; i < N; i++){
            mapCopy[i] = Arrays.copyOf(map[i], M);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        mapCopy = new int[N][M];
        zeros = new ArrayList<>();
        virus = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int what = Integer.parseInt(st.nextToken());
                map[i][j] = what;
                if (what == 0)
                    zeros.add(new Dot(i, j));
                else if (what == 2)
                    virus.add(new Dot(i, j));
            }
        }
        for(int i = 0; i < zeros.size() - 2; i++){
            for(int j = i + 1; j < zeros.size() - 1; j++){
                for(int k = j + 1; k < zeros.size(); k++){
                    count = 0;
                    visited = new int[N][M];
                    copyMapCopy();
                    wall[0] = i;wall[1] = j;wall[2] = k;
                    makeWall();
                    for(Dot dot : virus) {
                        visited[dot.y][dot.x] = 1;
                        bfs(dot.y, dot.x);
                    }
                    countZero();
                    result = Math.max(count, result);
                    copyMap();
                }
            }
        }
        System.out.println(result);
    }
}