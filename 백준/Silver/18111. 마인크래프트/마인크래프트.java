import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
       Map<Integer, Integer> heights_count = new TreeMap<>(Collections.reverseOrder());
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());
       int B = Integer.parseInt(st.nextToken());
       for (int i = 0; i < N; i++) {
           st = new StringTokenizer(br.readLine());
           for (int j = 0; j < M; j++) {
               int height = Integer.parseInt(st.nextToken());
               heights_count.put(height, heights_count.getOrDefault(height, 0) + 1);
           }
       }

       int answer_height = -1;
       int answer_time = Integer.MAX_VALUE;
       for(int compare_height = 0; compare_height <= 256; compare_height++) {
           int tmp_time = 0;
           int tmp_blocks = B;
           for(int current_height : heights_count.keySet()) {
               if(compare_height < current_height){
                   int calculate_result = (current_height - compare_height) * (heights_count.get(current_height));
                   tmp_time += calculate_result * 2;
                   tmp_blocks += calculate_result;
               }
               else if (compare_height > current_height){
                   int calculate_result = (compare_height - current_height) * (heights_count.get(current_height)); // 높이 차 * 블럭 개수
                   tmp_time += calculate_result;
                   tmp_blocks -= calculate_result;
               }
           }
           if (tmp_blocks < 0) continue;
           if(answer_time > tmp_time || (answer_time == tmp_time && answer_height < compare_height)){
               answer_time = tmp_time;
               answer_height = compare_height;
           }
       }
        System.out.println(answer_time + " " + answer_height);
    }
}
