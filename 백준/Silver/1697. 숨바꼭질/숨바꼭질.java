import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N >= K) {                 // 뒤로 걷기만 하면 됨
            System.out.println(N - K);
            return;
        }

        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> q = new ArrayDeque<>();
        dist[N] = 0;
        q.add(N);

        while (!q.isEmpty()) {
            int x = q.poll();
            if (x == K) {
                System.out.println(dist[x]);
                return;
            }

            int nx;

            nx = x - 1;
            if (nx >= 0 && dist[nx] == -1) {
                dist[nx] = dist[x] + 1;
                q.add(nx);
            }

            nx = x + 1;
            if (nx <= MAX && dist[nx] == -1) {
                dist[nx] = dist[x] + 1;
                q.add(nx);
            }

            nx = x * 2;
            if (nx <= MAX && dist[nx] == -1) {
                dist[nx] = dist[x] + 1;
                q.add(nx);
            }
        }
    }
}