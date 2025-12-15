import java.io.*;
import java.util.*;

class Node{
    int y, x, distance;
    int destroyed;

    Node(int y, int x, int distance, int destroyed){
        this.y = y;
        this.x = x;
        this.distance = distance;
        this.destroyed = destroyed;
    }
}

public class Main {

    static int N, M;
    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.y == N - 1 && current.x == M - 1) {
                System.out.println(current.distance);
                return;
            }
            for (int dir = 0; dir < 4; dir++) {
                int ny = current.y + dy[dir];
                int nx = current.x + dx[dir];
                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (map[ny][nx] == 1) {
                    if (current.destroyed == 0 && !visited[ny][nx][1]) {
                        visited[ny][nx][1] = true;
                        queue.offer(new Node(ny, nx, current.distance + 1, 1));
                    }
                }
                else {
                    if (!visited[ny][nx][current.destroyed]) {
                        visited[ny][nx][current.destroyed] = true;
                        queue.offer(new Node(ny, nx, current.distance + 1, current.destroyed));
                    }
                }
            }
        }
        System.out.println(-1);
    }
}