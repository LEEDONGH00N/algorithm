import java.io.*;
import java.util.*;

public class Main {

    // 동, 서, 남, 북
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static int[][] dice;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int current_y = Integer.parseInt(st.nextToken());
        int current_x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dice = new int[4][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++) {
            int go = Integer.parseInt(st.nextToken());
            int ny = current_y + dy[go - 1];
            int nx = current_x + dx[go - 1];
            if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
            int current_num = map[ny][nx];
            roll(go);
            if(current_num == 0) {
                map[ny][nx] = dice[3][1];
            }
            else{
                dice[3][1] = current_num;
                map[ny][nx] = 0;
            }
            System.out.println(dice[1][1]);
            current_y = ny;
            current_x = nx;
        }
    }

    static void roll(int dir){
        if(dir == 1){ // 동쪽으로 굴림
            int tmp = dice[1][0];
            dice[1][0] = dice[3][1];
            dice[3][1] = dice[1][2];
            dice[1][2] = dice[1][1];
            dice[1][1] = tmp;
        }
        else if (dir == 2){
            int tmp = dice[1][0];
            dice[1][0] = dice[1][1];
            dice[1][1] = dice[1][2];
            dice[1][2] = dice[3][1];
            dice[3][1] = tmp;
        }
        else if (dir == 3){
            int tmp = dice[0][1];
            dice[0][1] = dice[3][1];
            dice[3][1] = dice[2][1];
            dice[2][1] = dice[1][1];
            dice[1][1] = tmp;
        }
        else{
            int tmp = dice[0][1];
            dice[0][1] = dice[1][1];
            dice[1][1] = dice[2][1];
            dice[2][1] = dice[3][1];
            dice[3][1] = tmp;
        }
    }
}