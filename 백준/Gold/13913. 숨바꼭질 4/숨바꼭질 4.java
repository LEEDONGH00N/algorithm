import java.io.*;
import java.util.*;


class Node{
    int current;
    int pre;

    public Node(int current, int pre) {
        this.current = current;
        this.pre = pre;
    }
}
public class Main {
    static int N, K;
    static int[] visited, pre;
    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100001];
        pre = new int[1000001];
    }
    static void solution(){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        visited[N] = 1;
        pre[N] = 1000001;
        int[] moves = new int[3];
        while (!queue.isEmpty()){
            int current =  queue.poll();

            moves[0] = current + 1;
            moves[1] = current - 1;
            moves[2] = current * 2;

            for(int next : moves){
                if(0 <= next && next <= 100000) {
                    if (visited[next] == 0) {
                        queue.offer(next);
                        visited[next] = visited[current] + 1;
                        pre[next] = current;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(visited[K] - 1);
        List<Integer> list = new ArrayList<>();
        int tmp = K;
        list.add(K);
        do {
            list.add(pre[tmp]);
            tmp = pre[tmp];
        } while (tmp != 1000001);
        for(int i = list.size() - 2; i >= 0; i--){
            System.out.print(list.get(i) + " ");
        }
    }
}