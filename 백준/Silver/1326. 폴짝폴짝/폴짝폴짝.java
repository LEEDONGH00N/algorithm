import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int start;
    static int end;
    static int[] stones;
    static int[] dist;
    static Queue<Integer> queue;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        stones = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        queue = new ArrayDeque<>();
        dist = new int[N+1];
        Arrays.fill(dist, -1);
    }
    private static void solution() {
        queue.offer(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == end) {
                System.out.println(dist[current]);
                return;
            }
            int jump = stones[current];
            for (int next = current + jump; next <= N; next += jump) {
                if (dist[next] == -1) {
                    dist[next] = dist[current] + 1;
                    queue.offer(next);
                }
            }
            for (int next = current - jump; next > 0; next -= jump) {
                if (dist[next] == -1) {
                    dist[next] = dist[current] + 1;
                    queue.offer(next);
                }
            }
        }
        System.out.println(-1);
    }
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}