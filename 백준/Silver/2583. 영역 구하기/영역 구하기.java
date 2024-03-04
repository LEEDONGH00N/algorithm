import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n; static int m; static int k;static int area = 0;
    static int[] dir = {1, 0, -1, 0, 0, 1, 0, -1};
    static int[][] visited;
    static void dfs(int i, int j) {
        if (visited[i][j] == 0){
            visited[i][j] = 1;
            area++;
            for (int d = 0; d < 4; d++) {
                int nx = i + dir[d * 2];
                int ny = j + dir[d * 2 + 1];
                if (ny < 0 || nx < 0 || nx >= m || ny >= n)
                    continue;
                if (visited[nx][ny] == 0)
                    dfs(nx, ny);

            }
        }
    }
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       m = Integer.parseInt(st.nextToken());
       n = Integer.parseInt(st.nextToken());
       k = Integer.parseInt(st.nextToken());
       visited = new int[m][n];
       List<Integer> list = new ArrayList<>();
       for(int i = 0; i <k; i++){
           st = new StringTokenizer(br.readLine());
           //시작점은 인덱스 번호대로 가고, 끝점은 -1로 하면 됨
           int start_x = Integer.parseInt(st.nextToken());
           int start_y = Integer.parseInt(st.nextToken());

           int end_x = Integer.parseInt(st.nextToken());
           int end_y = Integer.parseInt(st.nextToken());

           if(end_y < start_y){
               int tmp = end_y;
               end_y = start_y;
               start_y = tmp;
           }
           if(end_x < start_x){
               int tmp = end_x;
               end_x = start_x;
               start_x = tmp;
           }
           end_x--;end_y--;

           for(int j = start_y; j <= end_y; j++){
               for(int t = start_x; t <= end_x; t++){
                   visited[j][t] = 1;
               }
           }
       }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0) {
                    dfs(i, j);
                    list.add(area);
                    area = 0;
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i : list)
            System.out.print(i + " ");
    }
}