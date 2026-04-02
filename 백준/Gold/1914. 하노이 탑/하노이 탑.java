import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BigInteger count = BigInteger.TWO.pow(N).subtract(BigInteger.ONE);
        sb.append(count).append("\n");

        if (N <= 20) {
            hanoi(N, 1, 3, 2);
        }

        System.out.print(sb);
    }

    static void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }
        hanoi(n - 1, from, via, to);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(n - 1, via, to, from);
    }
}