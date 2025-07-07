import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] bottom = new int[H + 2]; 
        int[] top = new int[H + 2];

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                bottom[x]++;
            } else {
                top[x]++;
            }
        }

        for (int i = H - 1; i >= 1; i--) {
            bottom[i] += bottom[i + 1];
            top[i] += top[i + 1];
        }

        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 1; i <= H; i++) {
            int crash = bottom[i] + top[H - i + 1];
            if (crash < min) {
                min = crash;
                count = 1;
            } else if (crash == min) {
                count++;
            }
        }

        System.out.println(min + " " + count);
    }
}