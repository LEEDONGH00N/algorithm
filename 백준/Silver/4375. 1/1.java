import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            int n = Integer.parseInt(line);
            int remainder = 1 % n;
            int count = 1;
            
            while (remainder != 0) {
                remainder = (remainder * 10 + 1) % n;
                count++;
            }
            
            sb.append(count).append('\n');
        }
        
        System.out.print(sb);
    }
}