import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int ioi_length = 2 * N + 1;
        String P = "";
        for (int i = 0; i < ioi_length; i++) {
            if(i % 2 == 0){
                P += "I";
            }
            else {
                P += "O";
            }
        }
        int answer = 0;
        for (int i = 0; i < S.length(); i++){
            if(i + ioi_length - 1 >= S.length()) break;
            if(S.substring(i, i + ioi_length).equals(P)){
                answer++;
            }
        }
        System.out.println(answer);
    }
}
