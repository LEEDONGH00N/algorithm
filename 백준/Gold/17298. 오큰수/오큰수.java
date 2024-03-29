import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int N;
    static int[] num;
    static int[] tmp;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N]; tmp = new int[N];
        Arrays.fill(tmp, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            num[i] = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && num[stack.peek()] < num[i])
                tmp[stack.pop()] = num[i];
            stack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < N;i++)
            sb.append(tmp[i]).append(" ");
        System.out.println(sb);
    }
}