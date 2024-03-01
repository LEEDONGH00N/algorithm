import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int flag; static int N; static int M; static int count = 0;
    static List<Integer>[] arr;
    static int[] check;

    static void solution(int L){
        if (check[L] != 1) {// L번 간선이 방문된적이 없다면
            check[L] = 1; flag = 1;
            for(int i : arr[L]){
                if(check[i] != 1){ //정점 L번과 연결된 정점 i가 방문된적이 없을때만 i로 방문
                    solution(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new int[N+1];
        arr = new List[N+1];
        for(int i = 1; i <= N; i++)
            arr[i] = new ArrayList<>();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a].add(b);arr[b].add(a);
        }
        for(int i = 1; i <= N; i++){
            flag = 0;
            solution(i);
            if(flag == 1)//for 문이 끝났다는 것은 연결 요소가 끝났다는 것을 의미하므로 연결 요소 count + 1
                count++;
        }
        System.out.println(count);
    }
}
