package Mathmatics;

import java.util.Scanner;

public class num9461 {
    static long[] solution(){
        long[] array = new long[100];
        array[0] = 1;array[1] = 1;array[2] = 1;array[3] = 2;
        for(int i = 4; i < 100; i++){
            array[i] = array[i - 2] + array[i - 3];
        }
        return array;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] array = solution();
        for(int i = 0; i < N; i++) {
            System.out.println(array[sc.nextInt() - 1]);
        }
    }
}
