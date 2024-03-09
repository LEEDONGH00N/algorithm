import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n; static int m;static int bucket_location = 1;static int sum = 0;
    static int[] location;
    static void solution(int locate){
        if(bucket_location < locate)
        for(int i = 0; bucket_location + (m-1) + i <= n; i++){
            if((bucket_location + i <= locate)
                    &&(bucket_location + (m-1) + i >= locate)){

                bucket_location += i; sum += i;
                return;
            }
        }
        else{
            for(int i = 0; bucket_location - i >= 1; i++){
                if((bucket_location - i <= locate)
                        &&(bucket_location + (m-1) - i  >= locate)){
                    bucket_location -= i; sum += i;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int apple = Integer.parseInt(br.readLine());
        location = new int[apple];
        for(int i = 0; i < apple; i++)
            location[i] = Integer.parseInt(br.readLine());

        for(int locate : location)
            solution(locate);

        System.out.println(sum);
    }
}
