package DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class num2602 {
    static int[] virus;
    static List[] comp;
    static int count = 0;
    static void DFS(int computer){
        if(virus[computer] != 1) {
            virus[computer] = 1;
            count++;
            for(int i = 0; i < comp[computer].size(); i++)
                DFS((Integer) comp[computer].get(i));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        comp = new List[n+1];
        virus = new int[n+1];
        for(int i = 1; i <= n; i++)
            comp[i] = new ArrayList<Integer>();

        for(int i = 0; i < m; i++){
            int a = sc.nextInt();int b = sc.nextInt();
            comp[a].add(b); comp[b].add(a);
        }
        DFS(1);
        System.out.println(count-1);
    }
}
