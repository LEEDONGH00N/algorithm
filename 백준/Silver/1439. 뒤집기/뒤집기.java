import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int num = 1;

        for (int i = 1; i < input.length(); i++) {
            if(input.charAt(i) != input.charAt(i - 1)) {
                num++;
            }
        }
        System.out.println(num/2);
    }
}