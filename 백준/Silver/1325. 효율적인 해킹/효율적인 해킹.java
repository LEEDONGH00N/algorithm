import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] graph;
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // A B : A가 B를 신뢰 → B 해킹 시 A도 해킹 → 간선 B → A
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph[B].add(A);
        }

        int[] count = new int[N + 1];
        int max = 0;

        // 각 노드를 시작점으로 BFS
        for (int i = 1; i <= N; i++) {
            int c = bfs(i);
            count[i] = c;
            if (c > max) max = c;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (count[i] == max) sb.append(i).append(' ');
        }

        System.out.println(sb.toString().trim());
    }

    private static int bfs(int start) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        visited[start] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            cnt++;
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }
        return cnt;
    }
}