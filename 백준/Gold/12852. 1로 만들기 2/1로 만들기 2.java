import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[1000001][2];
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        for(int i = 1; i <= N; i++){
            if(i * 3 < 1000001) {
                if (arr[i * 3][0] != 0 && arr[i][0] + 1 < arr[i * 3][0]) {
                    arr[i * 3][0] = arr[i][0] + 1;
                    arr[i * 3][1] = i;
                } else if (arr[i * 3][0] == 0) {
                    arr[i * 3][0] = arr[i][0] + 1;
                    arr[i * 3][1] = i;
                }
            }

            if(i * 2 < 1000001) {
                if (arr[i * 2][0] != 0 && arr[i][0] + 1 < arr[i * 2][0]) {
                    arr[i * 2][0] = arr[i][0] + 1;
                    arr[i * 2][1] = i;
                } else if (arr[i * 2][0] == 0) {
                    arr[i * 2][0] = arr[i][0] + 1;
                    arr[i * 2][1] = i;
                }
            }

            if(i + 1 < 1000001) {
                if (arr[i + 1][0] != 0 && arr[i][0] + 1 < arr[i + 1][0]) {
                    arr[i + 1][0] = arr[i][0] + 1;
                    arr[i + 1][1] = i;
                } else if (arr[i + 1][0] == 0) {
                    arr[i + 1][0] = arr[i][0] + 1;
                    arr[i + 1][1] = i;
                }
            }
        }
        System.out.println(arr[N][0]);
        System.out.print(N + " ");
        for (int k = N; k != 1;){
            System.out.print(arr[k][1] + " ");
            k = arr[k][1];
        }
    }
}