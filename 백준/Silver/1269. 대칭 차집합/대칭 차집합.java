import java.io.*;
import java.util.*;

public class Main {
    static int[] result;
    static int a, b;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        result = new int[100000001];
        for (int i = 0; i < a; i++) {
            int num = Integer.parseInt(st.nextToken());
            result[num]++;
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            int num = Integer.parseInt(st.nextToken());
            result[num]++;
        }
    }
    static void solution() {
        int count = 0;
        for(int t : result){
            if(t == 1) count++;
        }
        System.out.println(count);
    }
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}