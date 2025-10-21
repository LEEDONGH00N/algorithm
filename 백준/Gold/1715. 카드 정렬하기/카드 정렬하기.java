import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        while (queue.size() != 1) {
            int a = queue.poll();
            int b = queue.poll();
            int merged = a + b;
            sum += merged;
            queue.offer(merged);
        }
        System.out.println(sum);
    }
}