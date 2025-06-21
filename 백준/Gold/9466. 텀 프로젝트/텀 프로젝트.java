import java.io.*;
import java.util.*;

public class Main {

    static int T, N;
    static int[] students;
    static boolean[] visited;
    static boolean[] finished;
    static int cnt;

    static void dfsIter(int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int curr = stack.peek();

            if (!visited[curr]) {
                visited[curr] = true;
            }

            int next = students[curr];

            if (!visited[next]) {
                stack.push(next);
            } else {
                if (!finished[next]) {
                    // 사이클 발견
                    cnt++;
                    for (int i = next; i != curr; i = students[i]) {
                        cnt++;
                    }
                }
                // 더 이상 갈 곳 없음 → pop
                stack.pop();
                finished[curr] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            students = new int[N + 1];
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            cnt = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    dfsIter(i);
                }
            }

            bw.write((N - cnt) + "\n");
        }
        bw.flush();
        bw.close();
    }
}