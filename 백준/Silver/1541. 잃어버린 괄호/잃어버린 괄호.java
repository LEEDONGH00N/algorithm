import java.io.*;

public class Main {
    public static int calculate(String expr) {
        int result = 0;
        int num = 0;
        int sign = 1;

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            }
        }
        result += sign * num; 
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = false;
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (char c : line.toCharArray()) {
            if (c == '-') flag = true;
            if (c == '+' && flag) sb.append('-');
            else sb.append(c);
        }
        String result = sb.toString();
        System.out.println(calculate(result));
    }
}