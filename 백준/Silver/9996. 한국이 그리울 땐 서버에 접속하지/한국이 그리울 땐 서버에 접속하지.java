import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] patterns = br.readLine().split("\\*");
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            if(line.length() >= patterns[0].length() + patterns[1].length()
                    && line.startsWith(patterns[0])
                    && line.endsWith(patterns[1])){
                System.out.println("DA");
            }
            else {
                System.out.println("NE");
            }
        }

    }
}
