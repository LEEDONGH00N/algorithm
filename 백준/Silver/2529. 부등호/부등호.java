import java.io.*;
import java.util.*;
public class Main {

    static int n;
    static long max = -1, min = 9999999999L;
    static String[] A;
    static List<Integer> num = new ArrayList<>();
    static boolean[] used;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new String[n];
        used = new boolean[10];
        for (int i = 0; i < n; i++) A[i] = st.nextToken();
    }

    static long makeNumber(){
        StringBuilder result = new StringBuilder();
        for(int t : num) result.append(t);
        return Long.parseLong(result.toString());
    }

    static void solution(){
        if(num.size() >= 2){
            int front = num.get(num.size() - 2);

            int back = num.get(num.size() - 1);
            String sign = A[num.size() - 2];
            if(sign.equals(">")){
                if(front < back) {
                    num.remove(Integer.valueOf(back));
                    used[back] = false;
                    return;
                }
            }
            else if(sign.equals("<")){
                if(front > back) {
                    num.remove(Integer.valueOf(back));
                    used[back] = false;
                    return;
                }
            }
        }
        if(num.size() == n + 1){
            max = Math.max(max, makeNumber());
            min = Math.min(min, makeNumber());
            return;
        }
        for(int j = 0; j <= 9; j++){
            if(used[j]) continue;
            used[j] = true; num.add(j);
            solution();
            used[j] = false; num.remove(Integer.valueOf(j));
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        solution();
        String result_max = String.valueOf(max);
        String result_min = String.valueOf(min);
        if(result_max.length() != n + 1){
            result_max = "0" + result_max;
        }
        if(result_min.length() != n + 1){
            result_min = "0" + result_min;
        }
        System.out.println(result_max);
        System.out.println(result_min);
    }
}