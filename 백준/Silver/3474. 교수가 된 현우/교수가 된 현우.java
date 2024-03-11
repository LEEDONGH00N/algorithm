import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            int count5 = 0;
            for(int j = 5; j <= num; j *= 5)
                count5 += num / j;
            System.out.println(count5);
        }

    }
}