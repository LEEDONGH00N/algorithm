import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < line.length(); i++){
            char c = line.charAt(i);
            if ('A' <= c && c <= 'Z'){
                c = (char) ('A' + ((c - 'A' + 13) % 26));
            }
            else if ('a' <= c && c <= 'z'){
                c = (char) ('a' + ((c - 'a' + 13) % 26));
            }
            sb.append(c);
        }
        System.out.println(sb);
    }
}
