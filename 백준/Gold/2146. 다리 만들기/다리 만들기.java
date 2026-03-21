import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int min = Integer.MAX_VALUE;
    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {-1, 1, 0, 0};
    static boolean[][] visited;
    static int[][] map;
    static List<List<int[]>> islands = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        int islandNum = -1;
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    islands.add(new ArrayList<>());
                    islandNum++;
                    find_islands(i, j, islandNum);
                }
            }
        }
        
        for(List<int[]> island : islands) {
            visited = new boolean[N][N];
            bfs_2(island);
        }
        System.out.println(min);
    }

    private static void find_islands(int start_y, int start_x, int islandNum) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start_y, start_x});
        visited[start_y][start_x] = true;
        islands.get(islandNum).add(new int[]{start_y, start_x});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int y = cur[0], x = cur[1];
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[ny][nx] == 0 || visited[ny][nx]) continue;
                visited[ny][nx] = true;
                islands.get(islandNum).add(new int[]{ny, nx});
                q.offer(new int[]{ny, nx});
            }
        }
    }

    private static void bfs_2(List<int[]> island) {
        Queue<int[]> q = new ArrayDeque<>();
        for(int[] dots : island){
            q.offer(dots);
            visited[dots[0]][dots[1]] = true;
        }
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size --> 0) {
                int[] cur = q.poll();
                int y = cur[0], x = cur[1];
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i], nx = x + dx[i];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= N || visited[ny][nx]) continue;
                    if(map[ny][nx] == 1 && !island.contains(new int[]{ny, nx})) { // 땅을 발견했는데, 현재 섬의 땅이 아님
                        min = Math.min(min, level);
                        return;
                    }
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny, nx});
                }
            }
            level++;
        }
    }
}
