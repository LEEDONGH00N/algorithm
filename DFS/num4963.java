package DFS;

import java.util.Scanner;

public class num4963 {
    static int count; static int x; static int y;
    static int[] dir = {-1, 0, 1, 0, 0, -1, 0, 1, -1 , 1, 1 , 1, 1, -1, -1, -1};//상 하 좌 우 북동 남동 남서 북서
    static int[][] check;
    static void solution(int x, int y){
        if (check[x][y] == 1) {
            check[x][y] = 0;
            for(int i = 0; i < 8; i++){
                if(check[x + dir[i*2]][y + dir[i*2 + 1]] == 1)
                    solution(x + dir[i*2],y + dir[i*2 + 1]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            count = 0;
            y = sc.nextInt();x = sc.nextInt();
            if(x == 0 && y == 0)
                break;
            check = new int[x+2][y+2];
            for(int i = 1; i <= x; i++){
                for(int j = 1; j <= y; j++)
                    check[i][j] = sc.nextInt();
            }
            for(int i = 1; i <= x; i++){
                for(int j = 1; j <= y; j++){
                    if(check[i][j] == 1) {
                        solution(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}