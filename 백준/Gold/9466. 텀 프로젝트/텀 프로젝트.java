import java.io.*;
import java.util.*;

public class Main {

    static int T;
    static int N;
    static int cnt;
    static boolean[] visited;
    static boolean[] finished;
    static int[] students;


    static void dfs(int start_student) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start_student);

        while (!stack.isEmpty()) {
            int current_student = stack.peek();
            int next_student = students[current_student];

            if (!visited[current_student]) {
                visited[current_student] = true;
            }
            if (!visited[next_student]) {
                stack.push(next_student);
                continue;
            }
            if (!finished[next_student]) {
                cnt++;
                for (int i = next_student; i != current_student; i = students[i]) {
                    cnt++;
                }
            }
            while (!stack.isEmpty()) {
                int node = stack.pop();
                finished[node] = true;
                if (node == current_student) break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            students = new int[N + 1];
            cnt = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    dfs(j);
                }
            }

            bw.write(N - cnt + "\n");
            bw.flush();
        }
        bw.close();
    }
}
