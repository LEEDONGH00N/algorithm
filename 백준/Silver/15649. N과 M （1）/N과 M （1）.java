import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] pick;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        pick = new int[M];
        dfs(0);
        System.out.print(sb.toString());
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                if (i > 0) sb.append(' ');
                sb.append(pick[i]);
            }
            sb.append('\n');
            return;
        }
        for (int num = 1; num <= N; num++) { 
            if (visited[num]) continue;
            visited[num] = true;
            pick[depth] = num;
            dfs(depth + 1);
            visited[num] = false;
        }
    }
}