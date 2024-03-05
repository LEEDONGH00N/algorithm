import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
class Spot{
    int x;
    int y;

    public Spot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n; static int m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] visited;
    static int[][] arr;
    static void bfs(int i, int j) {

        Queue<Spot> queue = new LinkedList<>();
        queue.add(new Spot(i, j));

        while (!queue.isEmpty()){
            Spot spot = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = spot.x + dx[d];
                int ny = spot.y + dy[d];

                if (ny < 0 || nx < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny] == 1 || arr[nx][ny] == 0) continue;
                queue.add(new Spot(nx, ny));
                arr[nx][ny] = arr[spot.x][spot.y] + 1;
                visited[nx][ny] = 1;
            }
        }
    }
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       n = Integer.parseInt(st.nextToken());
       m = Integer.parseInt(st.nextToken());
       visited = new int[n][m];
       arr = new int[n][m];
       for(int i = 0; i < n; i++){
           String tmp = br.readLine();
           for (int j = 0; j < m; j++){
               arr[i][j] = tmp.charAt(j) - '0';
           }
       }
       visited[0][0] = 1;
       bfs(0, 0);
        System.out.println(arr[n-1][m-1]);
    }
}