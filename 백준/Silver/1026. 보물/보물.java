import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        A.sort(Comparator.naturalOrder());
        B.sort(Comparator.reverseOrder());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += A.get(i) * B.get(i);
        }
        System.out.println(sum);
    }
}