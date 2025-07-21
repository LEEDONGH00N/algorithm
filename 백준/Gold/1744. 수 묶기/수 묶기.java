import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> positive = new PriorityQueue<>((a, b) -> b - a);
        Queue<Integer> negative = new PriorityQueue<>();
        int result = 0;
        int n = Integer.parseInt(br.readLine());
        if(n == 1){
            System.out.println(br.readLine());
            return;
        }
        for(int i = 0; i < n; i++) {
            int current = Integer.parseInt(br.readLine());
            if(current > 0) positive.offer(current);
            else negative.offer(current);
        }

        while(!positive.isEmpty()){
            int current = positive.poll();
            if(positive.isEmpty()) {
                result += current;
                break;
            }
            int next = positive.peek();
            if(next * current < next + current){
                result += current;
                continue;
            }
            result += (current * positive.poll());
        }

        while(!negative.isEmpty()) {
            int current = negative.poll();
            if (negative.isEmpty()) {
                result += current;
                break;
            }
            result += (current * negative.poll());
        }
        System.out.println(result);
    }
}