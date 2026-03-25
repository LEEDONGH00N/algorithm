import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ipv6 = br.readLine();
        String[] split_ipv6 = ipv6.split(":", -1);
        List<String> answer = new LinkedList<>();
        int none_idx = -1;

        for(int i = 0; i < split_ipv6.length; i++) {
            if(split_ipv6[i].length() == 1){
                answer.add("000" + split_ipv6[i]);
            }
            else if(split_ipv6[i].length() == 2){
                answer.add("00" + split_ipv6[i]);
            }
            else if(split_ipv6[i].length() == 3){
                answer.add("0" + split_ipv6[i]);
            }
            else if(split_ipv6[i].length() == 4){
                answer.add(split_ipv6[i]);
            }
            else{
                if(none_idx == -1) {
                    none_idx = i;
                }
            }
        }

        if(none_idx == -1){
            none_idx = answer.size();
        }
        while(answer.size() < 8){
            answer.add(none_idx, "0000");
            none_idx++;
        }

        for(int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i));
            if(i != answer.size() - 1){
                System.out.print(":");
            }
        }
    }
}
