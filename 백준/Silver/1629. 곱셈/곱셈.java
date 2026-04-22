import java.util.*;
import java.io.*;

public class Main {
    static long C;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        
        System.out.println(pow(A, B));
    }
    
    static long pow(long A, long B) {
        if (B == 1) return A % C;         // 기저 조건
        
        long half = pow(A, B / 2);        // A^(B/2) 구하기
        long result = (half * half) % C;  // 제곱
        
        if (B % 2 == 1) {                  // B가 홀수면 A 한 번 더 곱하기
            result = (result * A) % C;
        }
        return result;
    }
}