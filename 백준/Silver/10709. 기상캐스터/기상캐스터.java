import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int H, W;
    static int[][] JOI;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        JOI = new int[H][W];
    
        for(int i = 0; i < H; i++){
            String line = br.readLine();
            boolean flag = false;
            int sum = 0;
            for(int j = 0; j < W; j++){
                char tmp = line.charAt(j);
                if(tmp == 'c') {
                    JOI[i][j] = 0;
                    sum = 0;
                    flag = true;
                }
                else if(tmp == '.')
                {
                    if(!flag)
                        JOI[i][j] = -1;
                    else
                        JOI[i][j] = ++sum;
                }
            }
        }
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                System.out.print(JOI[i][j] + " ");
            }
            System.out.println();
        }
    }
}
