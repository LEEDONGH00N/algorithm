package Mathmatics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class num1004 {
    static List<Integer> calculate(int[][] planetSystem, int alpha, int beta){
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < planetSystem.length; i++){
            if(Math.pow(alpha - planetSystem[i][0], 2) + Math.pow(beta - planetSystem[i][1], 2)
                    < Math.pow(planetSystem[i][2], 2))
                result.add(i);
        }
        return result;
    }
    static int solution(int[][] planetSystem, int start_x, int start_y, int finish_x, int finish_y){
        List<Integer> startPoint = calculate(planetSystem, start_x, start_y);
        List<Integer> finishPoint = calculate(planetSystem, finish_x, finish_y);
        List<Integer> tmp = new ArrayList<>(startPoint);
        startPoint.removeAll(finishPoint);
        finishPoint.removeAll(tmp);
        return finishPoint.size() + startPoint.size();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String answer = "";
        int testCase = sc.nextInt();
        for(int i = 0; i < testCase; i++){
            int start_x = sc.nextInt();
            int start_y = sc.nextInt();
            int finish_x = sc.nextInt();
            int finish_y = sc.nextInt();
            int planetSystemCount = sc.nextInt();
            int[][] planetSystem = new int[planetSystemCount][3];
            for(int j = 0; j < planetSystemCount; j++){
                planetSystem[j][0] = sc.nextInt();
                planetSystem[j][1] = sc.nextInt();
                planetSystem[j][2] = sc.nextInt();
            }
            answer = answer + solution(planetSystem, start_x, start_y, finish_x, finish_y) + "\n";
        }
        System.out.print(answer);
    }
}
