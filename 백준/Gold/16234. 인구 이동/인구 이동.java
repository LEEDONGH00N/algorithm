import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Country{
    int y; int x; int proportion;
    public Country(int y, int x, int proportion) {
        this.y = y;
        this.x = x;
        this.proportion = proportion;
    }
}
public class Main {
    static int N, L, R;
    static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, 1, -1};
    static boolean[][] visited;
    static int[][] map, copy;
    static List<Country> list;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); L = Integer.parseInt(st.nextToken()); R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        copy = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
    static void BFS(int y, int x){
        Queue<Country> queue = new LinkedList<>();
        queue.add(new Country(y, x, map[y][x]));
        list.add(new Country(y, x, map[y][x]));
        visited[y][x] = true;
        while (!queue.isEmpty()){
            Country country = queue.poll();
            for(int d = 0; d < 4; d++){
                int ny = country.y + dy[d];
                int nx = country.x + dx[d];
                if(ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx]) continue;
                int diff = Math.abs(map[ny][nx] - country.proportion);
                if(diff >= L && diff <= R){
                    Country tmp = new Country(ny, nx, map[ny][nx]);
                    list.add(tmp);
                    queue.add(tmp);
                    visited[ny][nx] = true;
                }
            }
        }
    }
    static void proportionRebalance(){
        double totalProportion = 0; int calculatedProportion;
        for(Country country : list){
            totalProportion += country.proportion;
        }
        calculatedProportion = (int) Math.floor(totalProportion / list.size());
        for(Country country : list){
            map[country.y][country.x] = calculatedProportion;
        }
    }
    static boolean isMapChanged(){
        for(int i = 0 ; i < N; i++){
            if(Arrays.compare(copy[i], map[i]) != 0)
                return true;
        }
        return false;
    }
    static void mapCopy(){
        for(int i = 0 ; i < N; i++){
            copy[i] = Arrays.copyOf(map[i], N);
        }
    }
    public static void main(String[] args) throws IOException {
        int answer = 0;
        input();
        mapCopy();
        while (true){
            visited = new boolean[N][N];
            list = new ArrayList<>();
            for(int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    if(!visited[i][j]) {
                        BFS(i, j);
                        if(list.size() > 1)
                            proportionRebalance();
                        list.clear();
                    }
                }
            }
            if (!isMapChanged())
                break;
            mapCopy();
            answer++;
        }
        System.out.println(answer);
    }
}