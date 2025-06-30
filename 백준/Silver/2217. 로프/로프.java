import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(Comparator.reverseOrder());
        int max = list.get(0);
        for(int i = 1; i < N; i++) {
            int current = i + 1;
            int tmp = list.get(i) * current;
            if(max < tmp)    max = tmp;
           
         
        }
        System.out.println(max);
    }
}