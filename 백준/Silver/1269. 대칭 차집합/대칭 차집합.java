import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Integer> result = new HashMap<>();
    static int a, b;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(result.containsKey(num)){
                result.remove(num);
                continue;
            }
            result.put(num, result.getOrDefault(num, 0) + 1);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(result.containsKey(num)){
                result.remove(num);
                continue;
            }
            result.put(num, result.getOrDefault(num, 0) + 1);
        }
        System.out.println(result.size());
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}