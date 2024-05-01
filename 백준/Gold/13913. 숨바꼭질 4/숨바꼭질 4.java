import java.io.*;
import java.util.*;
public class Main {
    static int N, K;
    static int[] visited, pre;
    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[2001000];
        pre = new int[2001000];
    }
    static void solution(){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        visited[N] = 1;
        pre[N] = 2001000;
        int[] moves = new int[3];
        while (!queue.isEmpty()){
            int current =  queue.poll();

            moves[0] = current + 1;
            moves[1] = current - 1;
            moves[2] = current * 2;

            if(current == K)
                break;

            for(int next : moves){
                if(0 <= next && next <= 200100) {
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
        } while (tmp != 2001000);
        for(int i = list.size() - 2; i >= 0; i--){
            System.out.print(list.get(i) + " ");
        }
    }
}