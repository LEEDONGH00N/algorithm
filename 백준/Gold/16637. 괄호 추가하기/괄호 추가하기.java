import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int result = Integer.MIN_VALUE;
    static ArrayList<Integer> nums = new ArrayList<>();
    static ArrayList<Character> operator = new ArrayList<>();
    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String line = br.readLine();
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0)
                nums.add(Character.getNumericValue(line.charAt(i)));
            else
                operator.add(line.charAt(i));
        }

    }
    static void solution(int index, int total) {
        if (index == operator.size()) {
            result = Math.max(result, total);
            return;
        }
        int withBracket = calculate(total, nums.get(index + 1), operator.get(index));
        solution(index+1, withBracket);

        if (index + 2 <= nums.size() - 1) {
            withBracket = calculate(total, calculate(nums.get(index + 1), nums.get(index + 2), operator.get(index + 1)), operator.get(index));
            solution(index + 2, withBracket);
        }
    }
    static int calculate(int a, int b, char operator){
        switch (operator){
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        input();
        solution(0, nums.get(0));
        System.out.println(result);
    }
}