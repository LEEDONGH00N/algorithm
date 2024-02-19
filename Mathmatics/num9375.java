package Mathmatics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class num9375 {
    static int solution(String[] clothes){
        Map<String, Integer> map = new HashMap<>();
        for (String clothe : clothes) {
            map.put(clothe, map.getOrDefault(clothe, 1) + 1);
        }
        int sum = 1;
        for(Integer t : map.values())
            sum = sum * t;
        return sum - 1;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int j = 0; j < cases; j++) {
            int n = sc.nextInt();
            String[] clothes = new String[n];
            for (int i = 0; i < n; i++) {
                sc.next();
                clothes[i] = sc.next();
            }
            System.out.println(solution(clothes));
        }

    }
}
