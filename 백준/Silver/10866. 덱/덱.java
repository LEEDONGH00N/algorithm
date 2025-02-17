import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> deque = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] splits = br.readLine().split(" ");
            switch (splits[0]) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(splits[1]));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(splits[1]));
                    break;
                case "pop_front":
                    bw.write((deque.isEmpty() ? -1 : deque.pollFirst()) + "\n");
                    break;
                case "pop_back":
                    bw.write((deque.isEmpty() ? -1 : deque.pollLast()) + "\n");
                    break;
                case "size":
                    bw.write(deque.size() + "\n");
                    break;
                case "empty":
                    bw.write((deque.isEmpty() ? 1 : 0) + "\n");
                    break;
                case "front":
                    bw.write((deque.isEmpty() ? -1 : deque.getFirst()) + "\n");
                    break;
                case "back":
                    bw.write((deque.isEmpty() ? -1 : deque.getLast()) + "\n");
                    break;
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}