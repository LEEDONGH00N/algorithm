import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] list;
    static int[] parent;
    static void solution(int k){
        while (!list[k].isEmpty()) {
            int tmp = list[k].remove(0);
            parent[tmp] = k;
            list[tmp].remove(Integer.valueOf(k));
            solution(tmp);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        list = new List[n+1];
        parent = new int[n+1];

        for(int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();

        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
            list[a].add(b); list[b].add(a);
        }
        while (!list[1].isEmpty()) {
            int tmp = list[1].remove(0);
            parent[tmp] = 1;
            list[tmp].remove(Integer.valueOf(1));
            solution(tmp);
        }
        for(int i = 2; i <= n; i++)
            System.out.println(parent[i]);
    }
}