import java.util.*;
import java.io.*;

public class Main {

    static int answer = 0;
    static int a, b, c;
    static int[] arr = new int[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        solve();
        System.out.println(answer);
    }

    static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            for(int j = start; j < end; j++){
                arr[j]++;
            }
        }
    }

    static void solve() {
        for(int i = 1; i <= 100; i++){
            if(arr[i] == 1){
                answer += a;
            }
            else if (arr[i] == 2){
                answer += b * 2;
            }
            else if (arr[i] == 3){
                answer += c * 3;
            }
        }
    }
}
