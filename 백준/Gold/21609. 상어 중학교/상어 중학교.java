import java.io.*;
import java.util.*;

public class Main {

    static int N, M, score = 0;
    static boolean[][] globalVisited;
    static int[][] dirs = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };
    static int[][] game;

    static List<int[]> biggestGroup;
    static int maxRainbowCount = -1;
    static int[] standardBlock = {-1, -1};

    static void findAllBlockGroups() {
        globalVisited = new boolean[N][N];
        biggestGroup = new ArrayList<>();
        maxRainbowCount = -1;
        standardBlock = new int[]{-1, -1};

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!globalVisited[y][x] && game[y][x] > 0) {
                    bfs(y, x, game[y][x]);
                }
            }
        }
    }

    static void bfs(int sy, int sx, int color) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        List<int[]> currentGroup = new ArrayList<>();
        int rainbowCount = 0;

        queue.offer(new int[]{sy, sx});
        visited[sy][sx] = true;
        globalVisited[sy][sx] = true;
        currentGroup.add(new int[]{sy, sx});
        int[] std = {sy, sx};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0], x = cur[1];

            for (int[] d : dirs) {
                int ny = y + d[0];
                int nx = x + d[1];

                if (ny < 0 || ny >= N || nx < 0 || nx >= N || visited[ny][nx]) continue;

                if (game[ny][nx] == 0 || game[ny][nx] == color) {
                    queue.offer(new int[]{ny, nx});
                    visited[ny][nx] = true;
                    currentGroup.add(new int[]{ny, nx});

                    if (game[ny][nx] == 0) {
                        rainbowCount++;
                    } else {
                        globalVisited[ny][nx] = true;
                        if (ny < std[0] || (ny == std[0] && nx < std[1])) {
                            std = new int[]{ny, nx};
                        }
                    }
                }
            }
        }
        if (currentGroup.size() < 2) return;
        if (compareGroup(currentGroup, rainbowCount, std)) {
            biggestGroup = new ArrayList<>(currentGroup);
            maxRainbowCount = rainbowCount;
            standardBlock = std;
        }
    }

    static boolean compareGroup(List<int[]> group, int rainbowCnt, int[] std) {
        if (group.size() > biggestGroup.size()) return true;
        if (group.size() < biggestGroup.size()) return false;

        if (rainbowCnt > maxRainbowCount) return true;
        if (rainbowCnt < maxRainbowCount) return false;

        if (std[0] > standardBlock[0]) return true;
        if (std[0] < standardBlock[0]) return false;

        return std[1] > standardBlock[1];
    }

    static void removeGroup() {
        for (int[] pos : biggestGroup) {
            int y = pos[0], x = pos[1];
            game[y][x] = -2; // 빈칸 처리
        }
    }

    static void calculateScore() {
        int size = biggestGroup.size();
        score += size * size;
    }

    static void applyGravity() {
        for (int x = 0; x < N; x++) {
            for (int y = N - 2; y >= 0; y--) {
                if (game[y][x] >= 0) {
                    int ny = y;
                    while (ny + 1 < N && game[ny + 1][x] == -2) {
                        ny++;
                    }
                    if (ny != y) {
                        game[ny][x] = game[y][x];
                        game[y][x] = -2;
                    }
                }
            }
        }
    }

    static void rotate() {
        int[][] rotated = new int[N][N];

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                rotated[N - 1 - x][y] = game[y][x];
            }
        }
        game = rotated;
    }

    static void input(StringTokenizer st, BufferedReader br) throws IOException {
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        game = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        input(st, br);
        while (true) {
            findAllBlockGroups();
            if (biggestGroup.isEmpty()) break;
            removeGroup();
            calculateScore();
            applyGravity();
            rotate();
            applyGravity();
        }
        System.out.println(score);
    }
}