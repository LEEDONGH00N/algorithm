import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            if(n == 0){
                if(p.contains("D")) {
                    System.out.println("error");
                }
                else {
                    System.out.println("[]");
                }
                continue;
            }
            String[] nums = line.substring(1, line.length() - 1).split(",");
            int start_idx = 0;
            int end_idx = nums.length - 1;
            boolean reverse = false;
            boolean isError = false;
            for(char method : p.toCharArray()) {
                if(method == 'R') {
                    reverse = !reverse;
                }
                else if (method == 'D') {
                    if(start_idx > end_idx){
                        isError = true;
                        break;
                    }
                    if(reverse){
                        end_idx--;
                    }
                    else{
                        start_idx++;
                    }
                }
            }
            if (isError) {
                System.out.println("error");
            }
            else {
                System.out.print("[");
                if(!reverse){
                    for (int idx = start_idx; idx <= end_idx; idx++) {
                        System.out.print(nums[idx]);
                        if(idx != end_idx){
                            System.out.print(",");
                        }
                    }
                }
                else{
                    for (int idx = end_idx; idx >= start_idx; idx--) {
                        System.out.print(nums[idx]);
                        if(idx != start_idx){
                            System.out.print(",");
                        }
                    }
                }
                System.out.println("]");
            }
        }
    }
}