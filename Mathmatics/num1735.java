package Mathmatics;

import java.util.Scanner;

public class num1735 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] n = new int[2];
        int[] m = new int[2];
        //0  : 분자, 1 : 분모
        n[0] = sc.nextInt();
        n[1] = sc.nextInt();
        m[0] = sc.nextInt();
        m[1] = sc.nextInt();
        int i = 1, j = 1;
        while(n[1] * i != m[1] * j){
            if(n[1] * i > m[1] * j)
                j++;
            else if (n[1] * i < m[1] * j)
                i++;
        }
        int a = n[0] * i + m[0] * j;
        int b = n[1] * i;
        for(int k = a; k >= 2; k--){
            if(a % k == 0 && b % k == 0){
                a /= k;
                b /= k;
                k = a + 1;
            }
            if(a == 1)
                break;
        }
        System.out.println(a + " " + b);
    }
}
