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

    static int N, M, minDistance = Integer.MAX_VALUE;
    static int[][] map;
    static Dot[] chicken; static Dot[] house;

    static List<Dot> selectedChickenHouse = new ArrayList<>();

    static int calculateChickenDistance(){
        int result = 0;
        for(Dot dot : house){
            if(dot == null) break;
            int tmp = 2 * N + 1;
            for(Dot chickenHouse : selectedChickenHouse){
                tmp = Math.min(Math.abs(chickenHouse.y - dot.y) + Math.abs(chickenHouse.x - dot.x), tmp);
            }
            result += tmp;
        }
        return result;
    }

    static void solution(int chickenHouse, int count) {
        if(count >= M || chicken[chickenHouse] == null) {
            minDistance = Math.min(minDistance, calculateChickenDistance());
            return;
        }

        //폐업 안함
        selectedChickenHouse.add(chicken[chickenHouse]);
        solution(chickenHouse + 1, count + 1);

        //폐업 함
        selectedChickenHouse.remove(chicken[chickenHouse]);
        solution(chickenHouse + 1, count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+2][N+2];
        chicken = new Dot[14];
        house = new Dot[N * 2+1];
        int c_tmp = 0, h_tmp = 0;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                int what = Integer.parseInt(st.nextToken());
                map[i][j] = what;
                if(what == 2)
                    chicken[c_tmp++] = new Dot(i, j);
                else if(what == 1)
                    house[h_tmp++] = new Dot(i, j);
            }
        }

        solution(0, 0);
        System.out.println(minDistance);
    }
}
