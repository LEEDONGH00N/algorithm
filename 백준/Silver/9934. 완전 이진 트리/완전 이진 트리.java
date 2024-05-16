import java.io.*;
import java.util.*;
public class Main {
    static int k, size, tmp = 0;
    static int[] arr;
    static int[] result;
    static boolean[] visited;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        size = (int) Math.pow(2, k);
        arr = new int[size];
        result = new int[size];
        visited = new boolean[size + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void visit(int node){
        result[node] = arr[tmp];
        visited[node] = true;
    }
    static void solution(int node){
        if(node < size && !visited[node]){
            int left = node * 2;
            int right = node * 2 + 1;
            solution(left);
            visit(node);
            tmp++;
            solution(right);
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        solution(1);
        int tmp = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= k; i++){
            int a = (int) Math.pow(2, i);
            for(int j = tmp; j < a; j++){
                sb.append(result[j]);
                sb.append(" ");
            }
            tmp = a;
            sb.append("\n");
        }
        System.out.println(sb);
    }
}