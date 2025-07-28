import java.io.*;
import java.util.*;

class Point{
    int y, x, dir, cost;
    Point(int y, int x, int dir, int cost) {
        this.y   = y;
        this.x   = x;
        this.dir = dir;
        this.cost = cost;
    }
}

public class Main {

    static int W, H;
    static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    static char[][] map;
    static int[][][] cost;
    static Queue<int[]> laser = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        input();
        int[] start = laser.poll();
        int[] end   = laser.poll();
        bfs(start, end);
    }

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map  = new char[H][W];
        cost = new int[4][H][W];
        for (int d = 0; d < 4; d++)
            for (int i = 0; i < H; i++)
                Arrays.fill(cost[d][i], Integer.MAX_VALUE);

        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'C') laser.offer(new int[]{i, j});
            }
        }
    }

    static void bfs(int[] start, int[] end) {
        Deque<Point> dq = new ArrayDeque<>();
        for (int d = 0; d < 4; d++)
            cost[d][start[0]][start[1]] = 0;
        dq.offerFirst(new Point(start[0], start[1], -1, 0));

        while (!dq.isEmpty()) {
            Point p = dq.pollFirst();
            if (p.y == end[0] && p.x == end[1]) {
                int a = cost[0][p.y][p.x], b = cost[1][p.y][p.x];
                int c = cost[2][p.y][p.x], d = cost[3][p.y][p.x];
                System.out.println(Math.min(Math.min(a,b), Math.min(c,d)));
                return;
            }

            for (int d = 0; d < 4; d++) {
                int ny = p.y + dirs[d][0], nx = p.x + dirs[d][1];
                if (ny < 0 || ny >= H || nx < 0 || nx >= W) continue;
                if (map[ny][nx] == '*') continue;

                int nextCost = (p.dir == -1 || p.dir == d) ? p.cost : p.cost + 1;
                if (nextCost < cost[d][ny][nx]) {
                    cost[d][ny][nx] = nextCost;
                    Point nxt = new Point(ny, nx, d, nextCost);

                    if (nextCost == p.cost) dq.offerFirst(nxt); // 가중치 0
                    else                    dq.offerLast(nxt);  // 가중치 1
                }
            }
        }
    }
}