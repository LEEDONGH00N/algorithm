import java.io.*;
import java.util.*;

class Point implements Comparable<Point>{
    int y, x, dir, cost;
    Point(int y, int x, int dir, int cost) {
        this.y = y;
        this.x = x;
        this.dir = dir;
        this.cost = cost;
    }

    @Override
    public int compareTo(Point o) {
        return this.cost - o.cost;
    }
}

public class Main {

    static int W, H;
    static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    static char[][] map;
    static int[][] cost0, cost1, cost2, cost3;
    static Queue<int[]> laser = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        input();
        int[] start = laser.poll(); int[] end = laser.poll();
        bfs(start, end);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());H = Integer.parseInt(st.nextToken());
        map = new char[H][W];
        cost0 = new int[H][W];cost1 = new int[H][W];cost2 = new int[H][W];cost3 = new int[H][W];
        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'C') laser.offer(new int[]{i, j});
                cost0[i][j] = cost1[i][j] = cost2[i][j] = cost3[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    static void bfs(int[] s, int[] e) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        cost0[s[0]][s[1]] = cost1[s[0]][s[1]] = cost2[s[0]][s[1]] = cost3[s[0]][s[1]] = 0;
        queue.offer(new Point(s[0], s[1], -1, 0));
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            if (p.y == e[0] && p.x == e[1]) {
                int ans = Math.min(
                        Math.min(cost0[p.y][p.x], cost1[p.y][p.x]),
                        Math.min(cost2[p.y][p.x], cost3[p.y][p.x])
                );
                System.out.println(ans);
                return;
            }
            for (int d = 0; d < 4; d++) {
                int ny = p.y + dirs[d][0];
                int nx = p.x + dirs[d][1];
                if (ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
                if (map[ny][nx] == '*') continue;
                int nextCost;
                if (p.dir == -1 || p.dir == d) {
                    nextCost = p.cost;
                } else {
                    nextCost = p.cost + 1;
                }
                int[][] target;
                if (d == 0) {
                    target = cost0;
                } else if (d == 1) {
                    target = cost1;
                } else if (d == 2) {
                    target = cost2;
                } else {
                    target = cost3;
                }
                if (nextCost < target[ny][nx]) {
                    target[ny][nx] = nextCost;
                    queue.offer(new Point(ny, nx, d, nextCost));
                }
            }
        }
    }
}