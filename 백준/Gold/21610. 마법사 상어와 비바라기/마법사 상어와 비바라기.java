import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] diagonalY = {1, 1, -1, -1};
    static int[] diagonalX = {-1, 1, -1, 1};
    static boolean[][] visited;
    static int[][] A;
    static int[][] cloud;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N + 2][N + 2];
        cloud = new int[N + 2][N + 2];
        initCloud();
        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 1; c <= N; c++) {
                A[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            visited = new boolean[N + 2][N + 2];
            st = new StringTokenizer(br.readLine());
            int di = Integer.parseInt(st.nextToken());
            int si = Integer.parseInt(st.nextToken());
            //구름 이동 후 물 추가
            moveCloud(di, si);
            // 구름 대각선 방향으로 물 개수 확인 후 덧셈
            countWaterDiagonal();
            // 모든 칸 순회해 구름 생성
            createNewCloud();
        }
        System.out.println(countAllWater());
    }

    static void moveCloud(int di, int si) {
        int[][] newCloud = new int[N + 2][N + 2];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (cloud[i][j] == 1) {
                    int ny = ((i + dy[di] * si - 1) % N + N) % N + 1;
                    int nx = ((j + dx[di] * si - 1) % N + N) % N + 1;

                    A[ny][nx] += 1;
                    newCloud[ny][nx] = 1;
                    visited[ny][nx] = true;
                }
            }
        }
        cloud = newCloud;
    }

    static void countWaterDiagonal(){
        // cloud 배열의 모든 원소를 훓어야 함 -> N * N
        // 대각선 방향으로 물이 있는 칸 개수 확인 후 그 개수만큼 현재 구름이 있는 칸의 물 양 추가
        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(cloud[i][j] == 1){
                    int count = 0;
                    for(int k = 0; k < 4; k++) {
                        int ny = i + diagonalY[k];
                        int nx = j + diagonalX[k];
                        if(A[ny][nx] >= 1){
                            count++;
                        }
                    }
                    A[i][j] += count;
                    cloud[i][j] = 0;
                }
            }
        }
    }

    static void createNewCloud(){
        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if(A[i][j] >= 2 && !visited[i][j]){
                    cloud[i][j] = 1;
                    A[i][j] -= 2;
                }
            }
        }
    }

    static int countAllWater(){
        int result = 0;
        for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                result += A[i][j];
            }
        }
        return result;
    }

    static void initCloud() {
        cloud[N][1] = 1;
        cloud[N][2] = 1;
        cloud[N - 1][1] = 1;
        cloud[N - 1][2] = 1;
    }
}