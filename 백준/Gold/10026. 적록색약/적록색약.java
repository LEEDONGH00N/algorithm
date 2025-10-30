import java.io.*;
import java.util.*;

class Node{
    int y, x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    static int n;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static boolean[][] visited;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n];
        input(br);
        int count1 = BFS();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 'G') map[i][j] = 'R';
            }
        }
        visited = new boolean[n][n];
        int count2 = BFS();
        System.out.println(count1 + " " + count2);
    }

    static void input(BufferedReader br) throws IOException {
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }
    }

    static int BFS() {
        int count = 0;
        Queue<Node> queue = new ArrayDeque<>();
        Queue<Node> diffs = new ArrayDeque<>();
        boolean[][] queued = new boolean[n][n];
        queue.offer(new Node(0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int y = cur.y;
            int x = cur.x;
            char color = map[y][x];
            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i], nx = x + dx[i];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n || visited[ny][nx]) continue;
                if (color != map[ny][nx]) {
                    if (!queued[ny][nx]) {
                        diffs.offer(new Node(ny, nx));
                        queued[ny][nx] = true;
                    }
                    continue;
                }
                visited[ny][nx] = true;
                queue.offer(new Node(ny, nx));
            }
            if(queue.isEmpty()){
                while(!diffs.isEmpty()){
                    Node node = diffs.poll();
                    if(visited[node.y][node.x]) continue;
                    queue.offer(node);
                    break;
                }
                count++;
            }
        }
        return count;
    }
}