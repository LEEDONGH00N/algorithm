import java.io.*;
import java.util.*;
class Dot{
    int y, x, distance;
    boolean isFire;
    public Dot(int y, int x, boolean isFire) {
        this.y = y;
        this.x = x;
        this.isFire = isFire;
    }

    public Dot(int y, int x, int distance, boolean isFire) {
        this.y = y;
        this.x = x;
        this.distance = distance;
        this.isFire = isFire;
    }
}
public class Main {
    static int R, C, J_y, J_x , answer = 0;
    static boolean[][] visited;
    static char[][] map;
    static int[] dy = {-1 ,1, 0, 0}, dx = {0 ,0, 1, -1};
    static Queue<Dot> q = new ArrayDeque<>();
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for(int i = 0; i < R; i++){
            String line = br.readLine();
            for(int j = 0; j < C; j++){
                if(line.charAt(j) == 'J'){
                    J_y = i; J_x = j;
                }
                else if(line.charAt(j) == 'F'){
                    visited[i][j] = true;
                    q.offer(new Dot(i, j, true));
                }
                else if (line.charAt(j) == '#'){
                    visited[i][j] = true;
                }
            }
        }
    }
    static void BFS(int y, int x){
        while(!q.isEmpty()){
            Dot dot = q.poll();
            if(!dot.isFire && (dot.y == R-1 || dot.y == 0 || dot.x == C-1 || dot.x == 0)) {
                answer = dot.distance + 1;
                break;
            }
            for(int i = 0; i < 4; i++){
                int ny = dot.y + dy[i];
                int nx = dot.x + dx[i];
                if(!(ny >= R || nx >= C || ny < 0 || nx < 0) && !visited[ny][nx]) {
                    if(dot.isFire){
                        q.offer(new Dot(ny, nx, true));
                    }
                    else {
                        q.offer(new Dot(ny, nx, dot.distance +1, false));
                    }
                    visited[ny][nx] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        q.offer(new Dot(J_y, J_x,0, false));
        BFS(J_y, J_x);
        if(answer == 0) System.out.println("IMPOSSIBLE");
        else System.out.println(answer);
    }
}