import java.util.*;
import java.io.*;

public class Main {

    static String line;
    static int[] c_a = new int[26];
    static char[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input(br);
        solve();
    }

    private static void solve(){
        int idx = 0;
        for(int i = 0; i < 26; i++) {
            if(line.length() % 2 != 0
                    && c_a[i] % 2 != 0
                    && p[line.length() / 2] == ' '){ // 문자열 길이가 홀수이면서 알파벳 카운팅 수가 1인 알파벳은 가운데 가야 함.
                p[line.length() / 2] = (char) (i + 'A');
                c_a[i] -= 1;
            }
            while(c_a[i] >= 2){
                if(p[idx] == ' '
                        && p[line.length() - 1 - idx] == ' '){
                    p[idx] = (char) (i + 'A');
                    p[line.length() - 1 - idx] = (char) (i + 'A');
                    idx++;
                    c_a[i] -= 2;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < p.length; i++){
            if(p[i] != p[p.length - 1 - i] || p[i] == ' '){
                System.out.println("I'm Sorry Hansoo");
                return;
            }
            sb.append(p[i]);
        }
        System.out.println(sb);
    }

    private static void input(BufferedReader br) throws IOException {
        line = br.readLine();
        p = new char[line.length()];
        for (char c : line.toCharArray()) {
            c_a[c - 'A']++;
        }
        Arrays.fill(p, ' ');
    }
}
