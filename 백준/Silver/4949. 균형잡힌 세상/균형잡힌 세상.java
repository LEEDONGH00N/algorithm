import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack;
        boolean flag;
        while(true){
            flag = true;
            String line = br.readLine();
            stack = new Stack<>();
            if(line.equals("."))
                break;
            for(char t : line.toCharArray()){
                if(t == '[' || t == '('){
                    stack.push(t);
                }
                else if (t == ']'){
                    if(stack.isEmpty() || stack.peek() != '['){
                        flag = false;
                        break;
                    }
                    else if (stack.peek() == '[')
                        stack.pop();
                }
                else if (t == ')'){
                    if(stack.isEmpty() || stack.peek() != '('){
                        flag = false;
                        break;
                    }
                    else if (stack.peek() == '(')
                        stack.pop();
                }
            }
            if(!flag || !stack.isEmpty())
                System.out.println("no");
            else
                System.out.println("yes");
        }
    }
}