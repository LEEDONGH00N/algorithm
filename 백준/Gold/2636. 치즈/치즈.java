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
    static int N; static int M; static int size; static int time;
    static int[] dy = {-1, 1, 0, 0}; static int[] dx = {0, 0, 1, -1};
    static int[][] cheese;
    static int[][] visited;
    static List<Dot> side;

    static void dfs(int i, int j){
        visited[i][j] = 1;
        if(cheese[i][j] == 1){
            side.add(new Dot(i, j));
            return;
        }
        for(int d = 0; d < 4; d++){
            int ny = i + dy[d];
            int nx = j + dx[d];
            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if(visited[ny][nx] == 1) continue;
            dfs(ny, nx);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        size = 0; time = 0;
        cheese = new int[N][M]; visited = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                int isCheese = Integer.parseInt(st.nextToken());
                cheese[i][j] = isCheese;
                if(isCheese == 1)
                    size++;
            }
        }
        while(size != 0){
            for(int i = 0; i < N; i++)
                Arrays.fill(visited[i], 0);
            side = new ArrayList<>();
            dfs(0, 0);
            time++;
            for(Dot dot : side)
                cheese[dot.y][dot.x] = 0;
            if(size - side.size() == 0){
                System.out.println(time);
                System.out.println(size);
                break;
            }
            size -= side.size();
        }
    }
}