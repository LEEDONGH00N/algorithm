import java.util.*;
import java.io.*;

public class Main {

    static int N, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        solve(br);
        System.out.println(answer);
    }

    static void solve(BufferedReader br) throws IOException {
        String line;
        Deque<Character> stack = new ArrayDeque<>();
        while (N --> 0) {
            line = br.readLine();
            if (line.length() % 2 != 0) continue;
            stack.clear();
            for (char c : line.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty()) answer++;
        }
    }

    static void input(BufferedReader br) throws IOException {
       N = Integer.parseInt(br.readLine());
    }
}
