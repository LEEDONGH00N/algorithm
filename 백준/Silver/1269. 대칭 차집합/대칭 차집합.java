import java.io.*;
import java.util.*;

public class Main {
    static Set<Integer> A = new HashSet<>();
    static Set<Integer> B = new HashSet<>();
    static int a, b;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) A.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) B.add(Integer.parseInt(st.nextToken()));
    }
    static void solution() {
        Set<Integer> tmp = new HashSet<>(A);
        A.removeAll(B);
        B.removeAll(tmp);

        Set<Integer> result = new HashSet<>();
        result.addAll(A);
        result.addAll(B);
        System.out.println(result.size());
    }
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}