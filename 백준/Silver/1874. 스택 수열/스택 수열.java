import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        int start = 0;
        while (count++ <= n){
            int num = Integer.parseInt(br.readLine());
            if(start < num){
                for(int i = start + 1; i <= num; i++){
                    stack.push(i);
                    sb.append("+\n");
                }
                start = num;
            }
            if(num == stack.peek()){
                stack.pop();
                sb.append("-\n");
            }
            else{
                System.out.println("NO");
                return;
            }
            if(count == n)
                break;
        }
        System.out.println(sb);
    }
}