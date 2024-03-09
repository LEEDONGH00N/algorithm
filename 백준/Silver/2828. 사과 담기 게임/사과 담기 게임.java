import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n; static int m;static int bucket_start = 1;static int sum = 0; static int bucket_last;
    static void solution(int locate){
        bucket_last = bucket_start + (m-1);
        if(bucket_start < locate){
            for(int i = 0; bucket_last + i <= n; i++){
                if((bucket_start + i <= locate)
                        &&(bucket_last + i >= locate)){
                    bucket_start += i; sum += i;
                    return;
                }
            }
        }
        else{
            for(int i = 0; bucket_start - i >= 1; i++){
                if((bucket_start - i <= locate)
                        &&(bucket_last - i  >= locate)){
                    bucket_start -= i; sum += i;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());

        int apple = Integer.parseInt(br.readLine());

        for(int i = 0; i < apple; i++) {
            int location = Integer.parseInt(br.readLine());
            solution(location);
        }
        System.out.println(sum);
    }
}