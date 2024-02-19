package Mathmatics;

import java.util.Scanner;

public class num1929 {
    static void solution(int M, int N){
        int[] array = new int[N + 1];
        array[1] = 1;
        for(int i = 2; i <= N; i++){
            for(int j = 2; i * j <= N; j++){
                array[i*j] = 1;
            }
        }
        for(int i = M; i <= N; i++){
            if(array[i] == 0)
                System.out.println(i);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        solution(M, N);
    }
}
