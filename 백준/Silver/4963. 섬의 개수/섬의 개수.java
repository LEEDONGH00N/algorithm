import java.util.*;

import java.io.*;
import java.util.*;

public class Main {

    static int count;
    static int x, y;
    static int[] dy = {-1, 1, 0 ,0, 1, 1, -1, -1};
    static int[] dx = {0, 0, 1, -1 ,1, -1, 1, -1};
    static int[][] arr;

    static void solution(int x, int y){
        if (arr[x][y] == 1) {
            arr[x][y] = 0;
            for(int i = 0; i < 8; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < arr.length && ny < arr[0].length && arr[nx][ny] == 1)
                    solution(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true){
            count = 0;
            st = new StringTokenizer(br.readLine());
            y = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken());

            if(x == 0 && y == 0)
                break;

            arr = new int[x][y];
            for(int i = 0; i < x; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < y; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < x; i++){
                for(int j = 0; j < y; j++){
                    if(arr[i][j] == 1) {
                        solution(i, j);
                        count++;
                    }
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
