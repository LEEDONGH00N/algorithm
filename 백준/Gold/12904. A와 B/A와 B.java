import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        boolean reversed = false;
        int left = 0, right = T.length() - 1;

        while (right - left + 1 > S.length()) {
            if (!reversed) {
                if (T.charAt(right) == 'A') {
                    right--;
                } else {
                    right--;
                    reversed = true;
                }
            } else {
                if (T.charAt(left) == 'A') {
                    left++;
                } else {
                    left++;
                    reversed = false;
                }
            }
        }
        
        StringBuilder result = new StringBuilder(T.substring(left, right + 1));
        if (reversed){
            result.reverse();
        }

        System.out.println(result.toString().equals(S) ? 1 : 0);
    }
}
