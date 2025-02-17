import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("push_front")) {
                deque.addFirst(Integer.parseInt(st.nextToken()));
            } else if (command.equals("push_back")) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            } else if (command.equals("pop_front")) {
                sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
            } else if (command.equals("pop_back")) {
                sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
            } else if (command.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            } else if (command.equals("front")) {
                sb.append(deque.isEmpty() ? -1 : deque.getFirst()).append("\n");
            } else if (command.equals("back")) {
                sb.append(deque.isEmpty() ? -1 : deque.getLast()).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}