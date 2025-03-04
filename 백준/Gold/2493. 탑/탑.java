import java.io.*;
import java.util.*;

class Top {
    int num;
    int height;

    Top(int num, int height) {
        this.num = num;
        this.height = height;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Stack<Top> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int height = Integer.parseInt(st.nextToken());

            Top currentTop = new Top(i, height);

            if(stack.isEmpty()) {
                answer.append("0 ");
                stack.push(currentTop);
                continue;
            }

            while(true){
                if (stack.isEmpty()) {
                    answer.append("0 ");
                    stack.push(currentTop);
                    break;
                }
                Top top = stack.peek();

                if (top.height > height) {
                    answer.append(top.num + " ");
                    stack.push(currentTop);
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        System.out.println(answer);
    }
}