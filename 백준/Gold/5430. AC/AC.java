import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            Deque<Integer> deque = new ArrayDeque<>();
            if(n == 0){
                if(p.contains("D")) {
                    sb.append("error\n");
                }
                else {
                    sb.append("[]\n");
                }
                continue;
            }
            String[] nums = line.substring(1, line.length() - 1).split(",");
            for (String num : nums) {
                deque.add(Integer.parseInt(num));
            }
            boolean reverse = false;
            boolean isError = false;
            for(char method : p.toCharArray()) {
                if(method == 'R') {
                    reverse = !reverse;
                }
                else if (method == 'D') {
                    if(deque.isEmpty()){
                        isError = true;
                        break;
                    }
                    if(reverse){
                        deque.removeLast();
                    }
                    else{
                        deque.removeFirst();
                    }
                }
            }
            if (isError) {
                sb.append("error\n");
            }
            else {
                Integer[] arr = deque.toArray(new Integer[0]);
                sb.append("[");
                if(!reverse){
                    for(int idx = 0; idx < arr.length; idx++){
                        sb.append(arr[idx]);
                        if(idx != arr.length - 1) sb.append(",");
                    }
                }
                else{
                    for(int idx = arr.length - 1; idx >= 0; idx--){
                        sb.append(arr[idx]);
                        if(idx != 0) sb.append(",");
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb);
    }
}