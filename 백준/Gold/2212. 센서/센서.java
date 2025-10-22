import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int K = Integer.parseInt(br.readLine().trim());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[N];
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(a);

        int[] unique = new int[N];
        int m = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0 || a[i] != a[i - 1]) unique[m++] = a[i];
        }
        if (K >= m) {
            System.out.println(0);
            return;
        }
        int[] gaps = new int[m - 1];
        for (int i = 0; i < m - 1; i++) {
            gaps[i] = unique[i + 1] - unique[i];
        }
        Arrays.sort(gaps);
        int total = unique[m - 1] - unique[0];
        int cut = 0;
        
        for (int i = 0; i < K - 1; i++) {
            cut += gaps[m - 2 - i];
        }
        System.out.println(total - cut);
    }
}