import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.addLast(i);
        }

        st = new StringTokenizer(br.readLine());
        int moveCount = 0;

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            // 현재 큐에서 목표 숫자의 인덱스 찾기
            int targetIdx = 0;
            for (int num : deque) {
                if (num == target) break;
                targetIdx++;
            }

            int leftMove = targetIdx;                 // 왼쪽 이동 횟수 (앞에서 target까지)
            int rightMove = deque.size() - targetIdx; // 오른쪽 이동 횟수 (뒤에서 target까지)

            if (leftMove <= rightMove) {
                // 왼쪽 이동이 더 빠른 경우
                moveCount += leftMove;
                while (leftMove-- > 0) {
                    deque.addLast(deque.pollFirst()); // 왼쪽으로 이동
                }
            } else {
                // 오른쪽 이동이 더 빠른 경우
                moveCount += rightMove;
                while (rightMove-- > 0) {
                    deque.addFirst(deque.pollLast()); // 오른쪽으로 이동
                }
            }

            // 맨 앞의 요소 제거
            deque.pollFirst();
        }

        System.out.println(moveCount);
    }
}