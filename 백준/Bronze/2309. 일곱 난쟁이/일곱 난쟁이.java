import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int[] arr = new int[9];
        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);
        int[] el = new int[1];
        for(int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if(100 + arr[i] + arr[j] == sum){
                    el = new int[]{i, j};
                    break;
                }
            }
        }
        for(int i = 0; i < 9; i++) {
            if (i != el[0] && i != el[1]){
                System.out.println(arr[i]);
            }
        }
    }

}
