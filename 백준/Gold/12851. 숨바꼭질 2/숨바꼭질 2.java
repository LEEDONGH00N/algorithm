import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] visited, count;
    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100010];
        count = new int[100010];
    }
    static void solution(){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);
        visited[N] = 1;
        count[N] = 1;
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
                        count[next] += count[current];
                    } else if (visited[next] == visited[current] + 1) {
                        count[next] += count[current];
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(visited[K] - 1);
        System.out.println(count[K]);

    }
}