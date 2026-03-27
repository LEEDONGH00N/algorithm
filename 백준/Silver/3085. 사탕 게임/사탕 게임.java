import java.util.*;
import java.io.*;

public class Main {
    static int N, answer = 0;
    static int[] dy = {1, 0};
    static int[] dx = {0, 1};
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                calculateRow(i, j);
                calculateCol(i, j);
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                char curCandy = map[y][x];
                for (int d = 0; d < 2; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];
                    if (ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] == curCandy) continue;

                    swapCandy(ny, nx, y, x);

                    calculateRow(y, x);
                    calculateCol(y, x);
                    calculateRow(ny, nx);
                    calculateCol(ny, nx);

                    swapCandy(ny, nx, y, x);
                }
            }
        }
        System.out.println(answer);
    }

    private static void calculateRow(int y, int x) {
        int tmpAnswer = 0;
        char currentColor = map[y][x];
        for (int col = 0; col < N; col++) {
            if (currentColor == map[y][col]) {
                tmpAnswer++;
            } else {
                if (col < x) {
                    tmpAnswer = 0;
                    continue;
                }
                break;
            }
        }
        answer = Math.max(answer, tmpAnswer);
    }

    private static void calculateCol(int y, int x) {
        int tmpAnswer = 0;
        char currentColor = map[y][x];
        for (int row = 0; row < N; row++) {
            if (currentColor == map[row][x]) {
                tmpAnswer++;
            } else {
                if (row < y) {
                    tmpAnswer = 0;
                    continue;
                }
                break;
            }
        }
        answer = Math.max(answer, tmpAnswer);
    }

    static void swapCandy(int ny, int nx, int y, int x) {
        char tmpCandy = map[ny][nx];
        map[ny][nx] = map[y][x];
        map[y][x] = tmpCandy;
    }
}
