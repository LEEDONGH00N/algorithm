import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i = 0; i < N; i++){
            Arrays.fill(map[i], -1);
        }

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            if(i == N-1) continue;
            int prev = map[i+1][0];
            for(int j = 0; j <= i; j++){
                if(map[i+1][j] < prev + map[i][j]){
                    map[i+1][j] = prev + map[i][j];
                }
                prev = map[i+1][j+1];
                map[i+1][j+1] += map[i][j];
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            if(map[N-1][i] > max){
                max = map[N-1][i];
            }
        }
        System.out.println(max);
    }
}