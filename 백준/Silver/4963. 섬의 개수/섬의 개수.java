import java.util.*;

import java.io.*;
import java.util.*;

public class Main {

    static int count;
    static int W, H;
    static int[] dh = {-1, 1, 0 ,0, 1, 1, -1, -1};
    static int[] dw = {0, 0, 1, -1 ,1, -1, 1, -1};
    static int[][] arr;

    static void solution(int h, int w){
        arr[h][w] = 0;
        for(int i = 0; i < 8; i++){
            int nh = h + dh[i];
            int nw = w + dw[i];
            if(nh >= 0 && nw >= 0 && nh < H && nw < W && arr[nh][nw] == 1)
                solution(nh, nw);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            count = 0;
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if(W == 0 && H == 0)
                break;

            arr = new int[H][W];
            for(int i = 0; i < H; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < W; j++)
                    arr[i][j] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < H; i++){
                for(int j = 0; j < W; j++){
                    if(arr[i][j] == 1) {
                        solution(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
