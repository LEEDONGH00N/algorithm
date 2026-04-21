import java.util.*;
import java.io.*;

public class Main {

    static int N, K, answer;
    static int temp_cal = 0;
    static int[] temp;

    public static void main(String[] args) throws IOException {
        input();
        init();
        answer = temp_cal;
        solve();
        System.out.println(answer);
    }

    private static void init() { // 초기값 설정
        for (int idx = 0; idx < K; idx++) {
            temp_cal += temp[idx];
        }
    }

    private static void solve() {
        int left = 0;
        int right = K-1;
        while(right != N - 1){
            temp_cal = temp_cal - temp[left++] + temp[++right];
            answer = Math.max(answer, temp_cal);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        temp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }
    }
}
