package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class num24479 {
    static int[] visited;
    static List<Integer>[] list;
    static int count = 1;
    static void dfs(int start){
        visited[start] = count++;
        for(int i : list[start]){
            if(visited[i] == 0)
                dfs(i);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());int M = Integer.parseInt(st.nextToken());int R = Integer.parseInt(st.nextToken());
        visited = new int[N+1];
        list = new List[N+1];
        for(int i = 1; i <= N; i++)
            list[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
            list[a].add(b); list[b].add(a);
        }
        for(int i = 1; i <= N; i++)
            Collections.sort(list[i]);

        dfs(R);

        for(int i = 1; i <= N; i++)
            System.out.println(visited[i]);
    }

}
