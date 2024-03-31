import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int solution(String iron){
        Stack<Character> stack = new Stack<>();
        char pre = ' ';
        int answer = 0;
        for(char t : iron.toCharArray()){
            if(t == '(')
                stack.push(t);
                // t == ')'
            else {
                stack.pop();
                if(pre == '('){ // 이게 레이저이면 -> 레이저가 쇠막대기를 자름
                    answer += stack.size();
                }
                else { //막대의 끝을 알림
                    answer++;
                }
            }
            pre = t;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String iron = br.readLine();
        System.out.println(solution(iron));
    }
}
