import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        for(int i = money / 5; i >= 0; i--) {
            int a = money - i * 5;
            if(a % 2 == 0){
                System.out.println(i + (a/2));
                return;
            }
        }
        System.out.println(-1);
    }
}