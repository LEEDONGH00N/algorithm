import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] check;
    static int[][] graph;
    static int n; static int count = 0;
    static void DFS(int start){
        check[start] = 1;
        for(int i = 1; i <= n; i++){
            if(graph[start][i] == 1 && check[i] != 1){
                count++;
                DFS(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        check = new int[n+1];
        graph = new int[n+1][n+1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1; graph[b][a] = 1;
        }
        DFS(1);
        System.out.println(count);
    }
}
