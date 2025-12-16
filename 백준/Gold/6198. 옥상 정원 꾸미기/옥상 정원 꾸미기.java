import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        long ans = 0;

        for (int i = 0; i < N; i++) {
            int h = Integer.parseInt(br.readLine());
            while (!stack.isEmpty() && stack.peekLast() <= h) {
                stack.pollLast();
            }
            ans += stack.size();
            stack.addLast(h);
        }

        System.out.println(ans);
    }
}