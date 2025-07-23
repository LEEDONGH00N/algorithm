import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(getMinBuy(N, K));
    }

    static int getMinBuy(int N, int K) {
        int buy = 0;
        while (countOnes(N) > K) {
            N++;
            buy++;
        }
        return buy;
    }
    
    static int countOnes(int x) {
        int cnt = 0;
        while (x > 0) {
            if (x % 2 == 1) cnt++;
            x = x / 2;
        }
        return cnt;
    }
}