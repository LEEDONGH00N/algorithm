import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long k = (long)((-1 + Math.sqrt(1 + 8 * n)) / 2);

        System.out.println(k);
    }
}