import java.io.*;
import java.util.*;

public class Main {

    static int N, M, H, tmp = Integer.MAX_VALUE;
    static boolean[][] visited;


    static void input() throws IOException{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        visited = new boolean[H + 1][N + 2];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            visited[a][b] = true;
        }
    }

    static boolean check(){
        for(int i = 1; i <= N; i++){
            int start = i;
            for(int j = 1; j <= H; j++){
                if(visited[j][start]) start++;
                else if(visited[j][start - 1]) start--;
            }
            if(start != i) return false;
        }
        return true;
    }
    static void goLadder(int start, int count){
        if(count > 3 || count >= tmp) return;
        if(check()) {
            tmp = Math.min(tmp, count);
            return;
        }
        for(int i = start; i <= H; i++){
            for(int j = 1; j <= N; j++){
                if(visited[i][j] || visited[i][j+1] || visited[i][j-1]) continue;
                visited[i][j] = true;
                goLadder(i, count+1);
                visited[i][j] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        goLadder(1, 0);
        if(tmp == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(tmp);
    }
}