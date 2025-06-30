import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int count = 0;
        for(int i = N - 2; i >= 0; i--){
            if(arr[i + 1] <= arr[i]){
                int x = arr[i + 1] - 1;
                count += arr[i] - x;
                arr[i] = x;
            }
        }
        System.out.println(count);
    }
}