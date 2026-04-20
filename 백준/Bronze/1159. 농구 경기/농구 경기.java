import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[26];
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            arr[name.charAt(0) - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (arr[i] >= 5) {
                sb.append((char) (i + 'a'));
            }
        }
        if(sb.toString().equals("")){
            sb.append("PREDAJA");
        }
        System.out.println(sb);
    }
}
