import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i : moves){
            for(int j = 0; j < board.length; j++){
                int doll = board[j][i-1];
                if(doll == 0) continue;
                if(stack.isEmpty() || stack.peek() != doll){
                    // 스택이 비어있거나 맨 위 인형이랑 다른 인형이면 삽입
                    stack.push(doll);
                }
                else{ // 스택 맨 위 인형이랑 doll이랑 같은 인형이면 삭제
                    stack.pop();
                    answer += 2;
                }
                board[j][i-1] = 0;
                break;
            }
        }
        return answer;
    }
}