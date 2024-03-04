import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int max = -1; static int count; static int height = 0;
    static int[] dir = {1, 0, -1, 0, 0, 1, 0, -1};
    static int[][] check; static int[][] visited;
    static void dfs(int i, int j) {
        visited[i][j] = 1;
        for (int d = 0; d < 4; d++) {
            if (check[i + dir[d * 2]][j + dir[d * 2 + 1]] > height &&
                    visited[i + dir[d * 2]][j + dir[d * 2 + 1]] == 0)
                dfs(i + dir[d * 2], j + dir[d * 2 + 1]);
        }
    }
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st;
       int n = Integer.parseInt(br.readLine());
       check = new int[n+2][n+2];
       visited = new int[n+2][n+2];
       for(int i = 1; i <= n; i++){
           st = new StringTokenizer(br.readLine());
           for(int j = 1; j <= n; j++)
               check[i][j] = Integer.parseInt(st.nextToken());
       }
       while (height != 101) {
           count = 0;
           for (int i = 1; i <= n; i++) {
               for (int j = 1; j <= n; j++) {
                   if (check[i][j] > height && visited[i][j] == 0) {
                       count++;dfs(i, j);
                   }
               }
           }
           if(count == 0)
               break;
           if (max < count)
               max = count;
           for (int i = 0; i < n + 2; i++)
               Arrays.fill(visited[i], 0);
           height++;
        }
        System.out.println(max);
    }
}