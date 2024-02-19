package Mathmatics;

import java.math.BigInteger;
import java.util.Scanner;

public class num2407 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger n = sc.nextBigInteger();
        BigInteger m = sc.nextBigInteger();

        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;

        if (m.compareTo(n.divide(BigInteger.valueOf(2))) > 0) {
            m = n.subtract(m);
        }

        for (BigInteger i = BigInteger.ZERO; i.compareTo(m) < 0; i = i.add(BigInteger.ONE)) {
            a = a.multiply(n.subtract(i));
            b = b.multiply(m.subtract(i));
        }
        System.out.println(a.divide(b));
    }
}
