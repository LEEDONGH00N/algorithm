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
    static int R, C, J_y, J_x , answer = 0;
    static int[][] jihoon, fire;
    static int[] dy = {-1 ,1, 0, 0}, dx = {0 ,0, 1, -1};
    static List<Dot> fires = new ArrayList<>();
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        jihoon = new int[R][C];
        fire = new int[R][C];
        for(int i = 0; i < R; i++)
            Arrays.fill(fire[i], Integer.MAX_VALUE);
        for(int i = 0; i < R; i++){
            String line = br.readLine();
            for(int j = 0; j < C; j++){
                if(line.charAt(j) == 'J'){
                    J_y = i; J_x = j;
                    jihoon[i][j] = 1;
                }
                else if(line.charAt(j) == 'F'){
                    fires.add(new Dot(i, j));
                    fire[i][j] = 1;
                }
                else if (line.charAt(j) == '#'){
                    fire[i][j] = -1;
                }
            }
        }
    }

    static void BFS_fire(int y, int x){
        Queue<Dot> queue = new LinkedList<>();
        queue.add(new Dot(y, x));
        while(!queue.isEmpty()){
            Dot dot = queue.poll();
            for(int i = 0; i < 4; i++){
                int ny = dot.y + dy[i];
                int nx = dot.x + dx[i];
                if(ny >= R || nx >= C || ny < 0 || nx < 0 || fire[ny][nx] == -1) continue;
                if(fire[ny][nx] <= fire[dot.y][dot.x] + 1) continue;
                fire[ny][nx] = fire[dot.y][dot.x] + 1;
                queue.add(new Dot(ny, nx));
            }
        }
    }

    static void BFS(int y, int x){
        Queue<Dot> queue = new LinkedList<>();
        queue.add(new Dot(y, x));
        while(!queue.isEmpty()){
            Dot dot = queue.poll();
            if(dot.y == R-1 || dot.y == 0 || dot.x == C-1 || dot.x == 0) {
                answer = jihoon[dot.y][dot.x];
                break;
            }
            for(int i = 0; i < 4; i++){
                int ny = dot.y + dy[i];
                int nx = dot.x + dx[i];
                if(ny >= R || nx >= C || ny < 0 || nx < 0 || fire[ny][nx] == -1 || jihoon[ny][nx] != 0) continue;
                if(fire[ny][nx] <= jihoon[dot.y][dot.x] + 1) continue;
                jihoon[ny][nx] = jihoon[dot.y][dot.x] + 1;
                queue.add(new Dot(ny, nx));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        for(Dot fire : fires) {
            BFS_fire(fire.y, fire.x);
        }
        BFS(J_y, J_x);
        if(answer == 0) System.out.println("IMPOSSIBLE");
        else System.out.println(answer);
    }
}