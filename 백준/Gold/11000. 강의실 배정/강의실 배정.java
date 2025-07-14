import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Queue<int[]> schedule = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            schedule.offer(new int[]{start, end});
        }
        PriorityQueue<Integer> room = new PriorityQueue<>();
        while (!schedule.isEmpty()) {
            int[] current = schedule.poll();
            if (!room.isEmpty() && room.peek() <= current[0]) {
                room.poll();
            }
            room.offer(current[1]);
        }

        System.out.println(room.size());
    }
}