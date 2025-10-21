import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.offer(scanner.nextInt());
        }

        int sum = 0;
        while (queue.size() != 1) {
            int a = queue.poll();
            int b = queue.poll();
            queue.offer(a+b);
            sum += a+b;
        }
        System.out.println(sum);
    }
}