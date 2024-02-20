package DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class num11724 {
    static int flag; static int N; static int M;static int count = 0;
    static int[] check;
    static List<Integer>[] arr;

    static void solution(int L){
        if (check[L] != 1) {// L번 간선이 방문된적이 없다면
            check[L] = 1; flag = 1;//flag는 연결요소에 대한 접근 여부
            for(int i : arr[L]){
                if(check[i] != 1) //정점 L번과 연결된 정점 i가 방문된적이 없을때만 i로 방문
                    solution(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        check = new int[N+1];
        arr = new List[N+1];
        for(int i = 1; i <= N; i++)
            arr[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a].add(b);
            arr[b].add(a);
        }
        for(int i = 1; i <= N; i++){
            flag = 0;
            solution(i);
            if(flag == 1)//solution에서 if문 에 들어갔다는 것은 연결요소로 들어갔다는 것을 의미
                // 연결 요소가 끝났다는 것을 의미하므로 연결 요소 count + 1
                count++;
        }
        System.out.println(count);
    }
}
