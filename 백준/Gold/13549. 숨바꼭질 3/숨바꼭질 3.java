import java.io.*;
import java.util.*;

class Node{
    int x, time;

    Node(int x, int time){
        this.x = x;
        this.time = time;
    }
}
public class Main {
    static int N, K, time = Integer.MAX_VALUE;
    static boolean[] visited;
    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100_001];
    }
    static void solution(){
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(N, 0));
        visited[N] = true;
        while (!queue.isEmpty()){
            Node current =  queue.poll();
            if(current.x == K) time = Math.min(time, current.time);

            int forward = current.x + 1;
            int backward = current.x - 1;
            int teleport = current.x * 2;

            if(teleport <= 100_000 && !visited[teleport]) {
                queue.offer(new Node(teleport, current.time));
                visited[teleport] = true;
            }
            if(0 <= backward && !visited[backward]) {
                queue.offer(new Node(backward, current.time+1));
                visited[backward] = true;
            }
            if(forward <= 100_000 && !visited[forward]) {
                queue.offer(new Node(forward, current.time+1));
                visited[forward] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        solution();
        System.out.println(time);
    }
}