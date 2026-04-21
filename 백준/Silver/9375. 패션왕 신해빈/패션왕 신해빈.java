import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int answer;
    static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        solve(br);
    }

    private static void solve(BufferedReader br) throws IOException {
        for(int i = 0; i < N; i++) {
            answer = 1;
            map = new HashMap<>();
            int m = Integer.parseInt(br.readLine());
            for(int j = 0; j < m; j++) {
                String[] style = br.readLine().split(" ");
                map.put(style[1], map.getOrDefault(style[1], 0) + 1);
            }
            for(String s : map.keySet()) {
                int count = map.get(s) + 1;
                answer *= count;
            }
            System.out.println(answer - 1);
        }
    }

    private static void input(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
    }
}
