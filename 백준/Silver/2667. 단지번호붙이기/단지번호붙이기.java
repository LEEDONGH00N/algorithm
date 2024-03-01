import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
public class Main {
    static int count;
    static int[] dir = {1, 0, -1, 0, 0, -1, 0, 1};
    static List<Integer> list;
    static int[][] check;

    static void DFS(int a, int b){
        check[a][b] = 0;
        count++;
        for(int i = 0; i < 4; i++) {
            if(check[a + dir[i * 2]][b + dir[i * 2 + 1]] == 1)
                DFS(a + dir[i * 2], b + dir[i * 2 + 1]);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();
        int T = Integer.parseInt(br.readLine());
        check = new int[T + 2][T + 2];
        
        for(int i = 0; i < T; i++){
            String apt = br.readLine();
            for(int j = 0; j < T; j++){
                char num = apt.charAt(j);
                check[i+1][j+1] = Character.getNumericValue(num);
            }
        }
        for(int i = 1; i <= T; i++){
            for(int j = 1; j <= T; j++){
                if(check[i][j] == 1){
                    count = 0;
                    DFS(i, j);
                    list.add(count);
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(int i : list)
            System.out.println(i);
    }
}