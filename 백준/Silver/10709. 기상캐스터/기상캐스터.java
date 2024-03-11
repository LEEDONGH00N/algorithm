import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int H, W;
    static int[] first_cloud_index;
    static int[][] JOI;
    static void solution(){
        for(int i = 0; i < H; i++){
            int sum = 0;
            if(first_cloud_index[i] == -1){
                Arrays.fill(JOI[i], -1);
                continue;
            }
            for(int j = 0; j < W; j++){
                if(j < first_cloud_index[i]){
                    JOI[i][j] = -1;
                }
                else{
                    if(JOI[i][j] == -2) {  // 구름이다!
                        JOI[i][j] = 0;
                        sum = 0;
                    }
                    else
                        JOI[i][j] = ++sum;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        JOI = new int[H][W];
        first_cloud_index = new int[H];
        Arrays.fill(first_cloud_index, -1);
        boolean flag;
        for(int i = 0; i < H; i++){
            String line = br.readLine();
            flag = false;
            for(int j = 0; j < W; j++){
                char tmp = line.charAt(j);
                if(tmp == 'c' ) {
                    JOI[i][j] = -2;
                    if(!flag){
                        first_cloud_index[i] = j;
                        flag = true;
                    }
                }
                else
                    JOI[i][j] = 0;
            }
        }
        solution();
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                System.out.print(JOI[i][j] + " ");
            }
            System.out.println();
        }
    }
}
