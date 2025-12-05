import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static ArrayList<Integer> pairSums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {  
                pairSums.add(arr[i] + arr[j]);
            }
        }
        Collections.sort(pairSums);
        for (int k = N - 1; k >= 0; k--) {
            int d = arr[k];
         
            for (int i = 0; i <= k; i++) { 
                int c = arr[i];
                int target = d - c;       

                if (existsPairSum(target)) {
                    System.out.println(d);
                    return;
                }
            }
        }
    }

    private static boolean existsPairSum(int target) {
        int left = 0;
        int right = pairSums.size() - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            int value = pairSums.get(mid);

            if (value == target) {
                return true;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}