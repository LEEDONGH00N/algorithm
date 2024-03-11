import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            int count2 = 0, count5 = 0;
            for(int j = 2; j <= num; j *= 2)
                count2 += num / j;
            for(int j = 5; j <= num; j *= 5)
                count5 += num / j;
            System.out.println(Math.min(count2, count5));
        }

    }
}