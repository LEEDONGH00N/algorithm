import java.io.*;
import java.util.*;

public class Main {

    // 북, 동, 남, 서
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int current_y = Integer.parseInt(st.nextToken());
        int current_x = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        while (true){

            //현재 있는 칸 청소 가능
            if (arr[current_y][current_x] == 0) {
                arr[current_y][current_x] = 2;
                count++;
            }

            boolean flag = false;
            for (int i = 0; i < 4; i++){
                int ny = current_y + dy[i];
                int nx = current_x + dx[i];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (arr[ny][nx] == 0) {
                    flag = true;
                    break;
                }
            }

            if (flag) {
                for (int i = 0; i < 4; i++) {
                    dir = (dir + 3) % 4;
                    int ny = current_y + dy[dir];
                    int nx = current_x + dx[dir];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                    if (arr[ny][nx] == 0) {
                        current_y = ny;
                        current_x = nx;
                        break;
                    }
                }
            } else {
                int ny = current_y + dy[(dir + 2) % 4];
                int nx = current_x + dx[(dir + 2) % 4];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M || arr[ny][nx] == 1) break; // 뒤가 벽이면 종료
                current_y = ny;
                current_x = nx;
            }
        }
        System.out.println(count);
    }
}