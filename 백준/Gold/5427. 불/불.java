import java.io.*;
import java.util.*;


class Node{
    boolean isFire;
    int y, x;

    public Node(boolean isFire, int y, int x) {
        this.isFire = isFire;
        this.y = y;
        this.x = x;
    }
}

public class Main {

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            int[][] map = new int[h][w];
            Queue<Node> queue = new ArrayDeque<>();
            Node kim = null;
            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    if (line.charAt(j) == '#') map[i][j] = 2;
                    else if (line.charAt(j) == '*') {
                        queue.offer(new Node(true, i, j));
                        map[i][j] = 9;
                    }
                    else if (line.charAt(j) == '.') map[i][j] = 0;
                    else if (line.charAt(j) == '@') {
                        kim = new Node(false, i, j);
                        map[i][j] = 1;
                    }
                }
            }
            if (kim.y == 0 || kim.y == h - 1 || kim.x == 0 || kim.x == w - 1) {
                System.out.println(1);
                continue;
            }
            int count = 1;
            queue.offer(kim);
            boolean canEscape = false;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int s = 0; s < size; s++) {
                    Node currernt = queue.poll();
                    if (currernt.isFire) {
                        for (int i = 0; i < 4; i++) {
                            int ny = currernt.y + dy[i];
                            int nx = currernt.x + dx[i];
                            if (nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
                            if (map[ny][nx] == 0 || map[ny][nx] == 1) {
                                map[ny][nx] = 9;
                                queue.offer(new Node(true, ny, nx));
                            }
                        }
                    } else {
                        for (int i = 0; i < 4; i++) {
                            int ny = currernt.y + dy[i];
                            int nx = currernt.x + dx[i];
                            if (nx < 0 || ny < 0 || nx >= w || ny >= h) continue;
                            if (map[ny][nx] == 0) {
                                if (ny == 0 || ny == h - 1 || nx == 0 || nx == w - 1) {
                                    canEscape = true;
                                    break;
                                }
                                map[ny][nx] = 1;
                                queue.offer(new Node(false, ny, nx));
                            }
                        }
                    }
                    if (canEscape) break;
                }
                if (canEscape) break;
                count++;
            }
            if (canEscape) {
                System.out.println(count + 1);
                continue;
            }
            System.out.println("IMPOSSIBLE");
        }
    }
}