import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Queue<int[]> dot = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            dot.offer(new int[]{start, end});
        }
        dot.offer(new int[]{1000000001, 1000000001});

        int start = -1000000001;
        int end = -1000000001;
        long result = 0;

        while(!dot.isEmpty()){
            int[] next = dot.poll();
            int next_start = next[0];
            int next_end = next[1];
            if (next_start > end) { 
                result += (end - start);
                start = next_start;
                end = next_end;
            } else {
                end = Math.max(end, next_end);
            }
        }
        System.out.println(result);
    }
}