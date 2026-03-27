import java.util.*;
import java.io.*;

public class Main {
    static int N, answer = 0;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        boolean[][] visited = new boolean[N][N];
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                calculate_column(i, j);
                calculate_row(i, j);
            }
        }

        for(int y = 0; y < N; y++) {
            for(int x = 0; x < N; x++) {
                char cur_candy = map[y][x];
                for(int d = 0; d < 4; d++){
                    int ny = y + dy[d];
                    int nx = x + dx[d];
                    if(ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] == cur_candy) continue;
                    // 사탕 교환
                    swap_candy(ny, nx, y, x);
                    
                    // (y,x) & (ny,nx)의 각 행/열 연속된 사탕 수 계산 -> 4개 for 문
                    
                    // 1. (y,x) 행 계산
                    calculate_column(y, x);

                    // 2. (y,x) 열 계산
                    calculate_row(y, x);

                    // 3. (ny,nx) 행 계산
                    calculate_column(ny, nx);

                    // 4. (ny,nx) 열 계산
                    calculate_row(ny, nx);

                    //원복
                    swap_candy(ny, nx, y, x);
                }
            }
        }
        System.out.println(answer);
    }

    private static void calculate_column(int y, int x) {
        int tmp_answer = 0;
        char current_color = map[y][x];
        for(int column_index = 0; column_index < N; column_index++) {
            if(current_color == map[y][column_index]) {
                tmp_answer++;
            }
            else{
                if(column_index < x) {
                    tmp_answer = 0;
                    continue;
                }
                break;
            }
        }
        answer = Math.max(answer, tmp_answer);
    }

    private static void calculate_row(int y, int x) {
        int tmp_answer = 0;
        char current_color = map[y][x];
        for(int row_index = 0; row_index < N; row_index++) {
            if(current_color == map[row_index][x]) {
                tmp_answer++;
            }
            else{
                if(row_index < y){
                    tmp_answer = 0;
                    continue;
                }
                break;
            }
        }
        answer = Math.max(answer, tmp_answer);
    }

    static void swap_candy(int ny, int nx, int y, int x) {
        char tmp_candy = map[ny][nx];
        map[ny][nx] = map[y][x];
        map[y][x] = tmp_candy;
    }
}
