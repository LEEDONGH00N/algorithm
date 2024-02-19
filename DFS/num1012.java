package DFS;

import java.util.Scanner;
public class num1012 {
    static int m;
    static int n;
    static int k;
    static int answer;
    static int[] dir = {1, 0, -1, 0, 0, -1, 0, 1};

    static void DFS(int a, int b, int[][] check){
        if(check[a][b] == 1){
            check[a][b] = 0;
            for(int i = 0; i < 4; i++) {
                if(check[a + dir[i * 2]][b + dir[i * 2 + 1]] == 1)
                    DFS(a + dir[i * 2], b + dir[i * 2 + 1], check);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            answer = 0;
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();
            int[][] check = new int[m+2][n+2];
            for(int j = 0; j < k; j++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                check[a+1][b+1] = 1;
            }
            for(int a = 1; a <= m; a++){
                for(int b = 1; b <= n; b++){
                    if(check[a][b] == 1){
                        DFS(a, b, check);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}