import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static LinkedList<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int cnt = 0;
        for(int i = 1; i <= N; i++) {
            deque.offer(i);
        }
        int[] nums = new int[M];
        for(int i = 0; i < M; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < M; i++){
            int numIdx = deque.indexOf(nums[i]);
            int middle;
            if(deque.size() % 2 == 0) {
                middle = deque.size() / 2;
            }
            else {
                middle = deque.size() / 2 + 1;
            }
            if(numIdx < middle){ //2번 계산
                for(int j = 0; j < numIdx; j++){
                    int tmp = deque.pollFirst();
                    deque.offerLast(tmp);
                    cnt++;
                }
            }
            else { // 3번 계산
                for(int j = deque.size() - 1; j >= numIdx; j--){
                    int tmp = deque.pollLast();
                    deque.offerFirst(tmp);
                    cnt++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(cnt);
    }
}