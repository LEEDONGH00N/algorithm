import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Country{
    int y; int x;
    public Country(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
public class Main {
    static boolean flag;
    static int N, L, R, sum;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, 1, -1};
    static boolean[][] visited;
    static int[][] map;
    static List<Country> list = new ArrayList<>();
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); L = Integer.parseInt(st.nextToken()); R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
    static void dfs(int y, int x){
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx]) continue;
            int diff = Math.abs(map[ny][nx] - map[y][x]);
            if(diff >= L && diff <= R){
                sum += map[ny][nx];
                list.add(new Country(ny, nx));
                visited[ny][nx] = true;
                dfs(ny, nx);
            }
        }

    }
    static void populationRebalanced(){
        for(Country country : list){
            map[country.y][country.x] = sum/list.size();
            flag = true;
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        int answer = 0;
        while (true){
            flag = false;
            visited = new boolean[N][N];
            for(int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    if(!visited[i][j]) {
                        list.clear();
                        visited[i][j] = true;
                        list.add(new Country(i, j));
                        sum = map[i][j];
                        dfs(i, j);
                        if(list.size() == 1) continue;
                        populationRebalanced();
                    }
                }
            }
            if(!flag) break;
            answer++;
        }
        System.out.println(answer);
    }
}