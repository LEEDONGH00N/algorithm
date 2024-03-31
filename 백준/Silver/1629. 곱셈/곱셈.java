import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static BigInteger A, B, C;

    static BigInteger solution(BigInteger i) {
        if (i.equals(BigInteger.ONE)) return A.mod(C);
        BigInteger tmp = solution(i.divide(BigInteger.valueOf(2)));
        tmp = (tmp.multiply(tmp)).mod(C);
        if (i.mod(BigInteger.valueOf(2)).equals(BigInteger.ONE))
            tmp = (tmp.multiply(A)).mod(C);
        return tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new BigInteger(st.nextToken());
        B = new BigInteger(st.nextToken());
        C = new BigInteger(st.nextToken());
        System.out.println(solution(B));
    }
}
