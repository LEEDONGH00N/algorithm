import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        for(int i = T.length() - 1; i >= S.length(); i--) {
            if(T.charAt(i) == 'A'){
                T = T.substring(0, i);
            }
            else if (T.charAt(i) == 'B'){
                T = T.substring(0, i);
                T = new StringBuilder(T).reverse().toString();
            }
        }
        if(T.equals(S)){
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }
}
