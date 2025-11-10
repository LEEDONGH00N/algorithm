import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    static int[] a;
    static long count = 0;

    static void dfs(int idx, long sum) {
        if (idx == N) {
            if (sum == S) count++;
            return;
        }
        dfs(idx + 1, sum + a[idx]);
        dfs(idx + 1, sum);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        a = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());
        dfs(0, 0);
        if (S == 0) {
            count--;
        }
        System.out.println(count);
    }
}