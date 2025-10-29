import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        if (S == G) {
            System.out.println(0);
            return;
        }

        int[] dist = new int[F + 1];
        Arrays.fill(dist, -1);

        Deque<Integer> q = new ArrayDeque<>();
        q.add(S);
        dist[S] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            // 위로 U층
            if (U > 0) {
                int up = cur + U;
                if (up <= F && dist[up] == -1) {
                    dist[up] = dist[cur] + 1;
                    if (up == G) {
                        System.out.println(dist[up]);
                        return;
                    }
                    q.add(up);
                }
            }

            // 아래로 D층
            if (D > 0) {
                int down = cur - D;
                if (down >= 1 && dist[down] == -1) {
                    dist[down] = dist[cur] + 1;
                    if (down == G) {
                        System.out.println(dist[down]);
                        return;
                    }
                    q.add(down);
                }
            }
        }

        System.out.println("use the stairs");
    }
}