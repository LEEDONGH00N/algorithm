import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BigInteger count = BigInteger.TWO.pow(N).subtract(BigInteger.ONE);
        System.out.println(count);

        if (N <= 20) {
            hanoi(N, 1, 3, 2);
        }
    }

    static void hanoi(int n, int from, int to, int via) {
        if (n == 1) {
            System.out.println(from + " " + to);
            return;
        }
        hanoi(n - 1, from, via, to);
        System.out.println(from + " " + to);
        hanoi(n - 1, via, to, from);
    }
}