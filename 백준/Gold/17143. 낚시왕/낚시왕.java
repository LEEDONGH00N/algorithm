import java.io.*;
import java.util.*;


class Shark{
    int y, x, size, num, speed;
    int[] v;
    public Shark(int y, int x, int speed, int[] dir, int size, int num) {
        this.y = y;
        this.x = x;
        this.speed = speed;
        this.size = size;
        this.num = num;
        this.v = dir;
    }
}

public class Main {

    static int fisher_index = 0;
    static int R, C, M, result = 0;
    static Shark[] sharks;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        input();
        while(fisher_index++ <= C){
            catch_shark();
            move_shark();
            can_kill_shark();
        }
        System.out.println(result);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[R+2][C+2];
        sharks = new Shark[M + 1];
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            int[] dir = new int[2];
            if(d == 1) dir = new int[]{-1, 0};
            else if (d == 2) dir = new int[]{1, 0};
            else if (d == 3) dir = new int[]{0, 1};
            else if (d == 4) dir = new int[]{0, -1};
            sharks[i] = new Shark(r, c, s, dir, z, i);
            arr[r][c] = i;
        }
    }

    static void catch_shark() {
        for (int i = 1; i <= R; i++) {
            int idx = arr[i][fisher_index];
            if (idx != 0) {
                if (sharks[idx] != null) {
                    result += sharks[idx].size;
                    sharks[idx] = null;
                    arr[i][fisher_index] = 0;
                    break;
                }
            }
        }
    }

    static void move_shark() {
        for (int i = 1; i <= M; i++) {
            Shark shark = sharks[i];
            if (shark == null) continue;
            int cy = shark.y, cx = shark.x, move = shark.speed;
            int vy = shark.v[0], vx = shark.v[1];
            if (vy != 0) {
                for (int m = 0; m < move; m++) {
                    if (cy + vy > R || cy + vy < 1) {
                        vy *= -1;
                    }
                    cy += vy;
                }
            }
            if (vx != 0) {
                for (int m = 0; m < move; m++) {
                    if (cx + vx > C || cx + vx < 1) {
                        vx *= -1;
                    }
                    cx += vx;
                }
            }
            shark.y = cy; shark.x = cx;
            shark.v[0] = vy; shark.v[1] = vx;
        }
    }
    static void can_kill_shark() {
        int[][] tmp = new int[R + 2][C + 2];
        for (int i = 1; i <= M; i++) {
            Shark shark = sharks[i];
            if (shark == null) continue;
            int y = shark.y, x = shark.x;
            int exist = tmp[y][x];
            if (exist == 0) {
                tmp[y][x] = shark.num;
            } else {
                if (sharks[exist].size < shark.size) {
                    sharks[exist] = null;
                    tmp[y][x] = shark.num;
                } else {
                    sharks[shark.num] = null;
                }
            }
        }
        arr = tmp;
    }

    static void printArr(){
        System.out.println("=============");
        for (int i = 1; i <= R; i++){
            for (int j = 1; j <= C; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}