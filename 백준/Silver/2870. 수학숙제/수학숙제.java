import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N; static List<BigInteger> list;
    static void solution(String line){
        String tmp = "";
        for(char x : line.toCharArray()){
            if(x=='0'||x=='1'||x=='2'||x=='3'||x=='4'||x=='5'||x=='6'||x=='7'||x=='8'||x=='9')
                tmp += Character.getNumericValue(x);
            else{
                if(!tmp.equals("")) {
                    list.add(new BigInteger(tmp));
                    tmp = "";
                }
            }
        }
        if(!tmp.equals("")) {
            list.add(new BigInteger(tmp));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            solution(line);
        }
        Collections.sort(list);
        for(BigInteger i : list)
            System.out.println(i);
    }
}
