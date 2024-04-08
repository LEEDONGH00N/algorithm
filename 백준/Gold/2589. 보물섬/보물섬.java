import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Dot{
    int y;
    int x;
    int count;
    public Dot(int y, int x, int count) {
        this.y = y;
        this.x = x;
        this.count = count;
    }
}
/*
*
* 암의의 한 점에서 BFS를 돌리고 가장 먼 지점을 찾음
* 그 점을 기준으로 다시 BFS를 돌려 최단거리 찾기
*
* */
public class Main {

    static int N, M;
    static int[] dy = {-1, 1, 0 ,0}; static int[] dx = {0, 0, 1 ,-1};
    static int[][] map; static int[][] visited;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                if(line.charAt(j) == 'W')
                    map[i][j] = 0;
                else
                    map[i][j] = 1;
            }
        }
    }

    static int BFS(int y, int x){
        Queue<Dot> queue = new LinkedList<>();
        Dot d = new Dot(y, x, 0);
        visited[y][x] = 1;
        queue.add(d);
        int result = 0;
        while(!queue.isEmpty()){
            Dot dot = queue.poll();
            int a = dot.y; int b = dot.x;
            for(int i = 0; i < 4; i++){
                int ny = a + dy[i]; int nx = b + dx[i];
                if(ny >= N || nx >= M || ny < 0 || nx < 0 || map[ny][nx] == 0 || visited[ny][nx] == 1) continue;
                if(map[ny][nx] >= 1){
                    visited[ny][nx] = 1;
                    Dot tmp = new Dot(ny, nx, dot.count + 1);
                    queue.add(tmp);
                    result = Math.max(result, dot.count+1);
                }
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        input();
        int answer = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1) {
                    visited = new int[N][M];
                    answer = Math.max(answer, BFS(i, j));
                }
            }
        }
        System.out.println(answer);
    }

}
