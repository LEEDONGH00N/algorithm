import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String answer = "";
    static int n;
    static int[][] arr;
    public static boolean isPossible(int y, int x, int size) {
        int value = arr[y][x];

        for(int i = y; i < y + size; i++) {
            for(int j = x; j < x + size; j++) {
                if(value != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    static void solution(int y, int x, int size){
        if(isPossible(y, x, size)) {
            answer += arr[y][x];
            return;
        }
        answer += "(";
        solution(y, x, size/2);
        solution(y, x + size/2, size/2);
        solution(y + size/2, x, size/2);
        solution(y+ size/2, x+ size/2, size/2);
        answer += ")";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for(int i = 0; i < n; i++){
            String tmp = br.readLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = tmp.charAt(j) - '0';
            }
        }
        solution(0, 0, n);
        System.out.println(answer);
    }
}
