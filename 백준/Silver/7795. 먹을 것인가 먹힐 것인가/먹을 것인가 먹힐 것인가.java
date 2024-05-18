import java.io.*;
import java.util.*;
public class Main {

    static int T;
    static int[] A;
    static int[] B;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A_size = Integer.parseInt(st.nextToken());
        int B_size = Integer.parseInt(st.nextToken());
        A = new int[A_size];
        B = new int[B_size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A_size; i++) A[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B_size; i++) B[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(B);
    }

    static int solution() {
        int count = 0;
        for (int j : A) {
            int mid = 0;
            int left = 0;
            int right = B.length - 1;
            while (left <= right) {
                mid = (left + right) / 2;
                if (j > B[mid]) left = mid + 1;
                else right = mid - 1;
            }
            count += left;
        }
        return count;
    }


    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            input();
            System.out.println(solution());
        }

    }
}