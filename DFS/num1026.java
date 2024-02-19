package DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class num1026 {
    static int[] check;
    static int[][] graph;
    static int n;
    static void DFS(int start){
        System.out.print(start + " ");
        check[start] = 1;
        for(int i = 1; i <= n; i++){
            if(graph[start][i] == 1 && check[i] != 1){
                DFS(i);
            }
        }
    }
    static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();
        System.out.print(start + " ");
        queue.offer(start);
        check[start] = 1;
        while (!queue.isEmpty()){
            int tmp = queue.poll();
            for(int i = 1; i <= n; i++){
                if(graph[tmp][i] == 1 && check[i] != 1){
                    check[i] = 1;
                    System.out.print(i + " ");
                    queue.offer(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt();
        check = new int[n+1];
        graph = new int[n+1][n+1];
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        DFS(start);
        for(int i = 1; i <= n; i++)
            check[i] = 0;
        System.out.println();
        BFS(start);
    }
}
