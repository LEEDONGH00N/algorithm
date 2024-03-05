import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n; static int m; static int k;static int count = 0; static int max = 0; static int area;
    static int[] dir = {1, 0, -1, 0, 0, 1, 0, -1};
    static int[][] visited;
    static void dfs(int i, int j) {
        if (visited[i][j] == 1){
            visited[i][j] = 0;
            count++;
            for (int d = 0; d < 4; d++) {
                int nx = i + dir[d * 2];
                int ny = j + dir[d * 2 + 1];
                if (ny < 0 || nx < 0 || nx >= m || ny >= n)
                    continue;
                if (visited[nx][ny] == 1)
                    dfs(nx, ny);

            }
        }
    }
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       m = Integer.parseInt(st.nextToken());
       n = Integer.parseInt(st.nextToken());
       visited = new int[m][n];
       for(int i = 0; i < m; i++){
           st = new StringTokenizer(br.readLine());
           for (int j = 0; j < n; j++){
               visited[i][j] = Integer.parseInt(st.nextToken());
           }
       }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 1) {
                    count = 0; area++;
                    dfs(i, j);
                    max = Math.max(max, count);
                }
            }
        }
        System.out.println(area);
        System.out.println(max);

    }
}