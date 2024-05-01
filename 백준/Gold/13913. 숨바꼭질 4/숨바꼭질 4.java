import java.io.*;
import java.util.*;
class Node{
    int now;
    Node pre;

    public Node(int now, Node pre) {
        this.now = now;
        this.pre = pre;
    }
}
public class Main {
    static int N, K;
    static boolean[] visited;
    static Deque<Integer> path = new ArrayDeque<>();
    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[200100];
    }
    static void goBack(){
        while (N >= K){
            System.out.print(N-- + " ");
        }
    }
    static void solution(){
        Node arrive = null;
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(N, null));
        visited[N] = true;
        int[] moves = new int[3];
        while (!queue.isEmpty()){
            Node current =  queue.poll();

            if(current.now == K) {
                arrive = current;
                break;
            }

            moves[0] = current.now + 1;
            moves[1] = current.now - 1;
            moves[2] = current.now * 2;

            for(int next : moves){
                if(next < 0 || next >= 200100 || visited[next]) continue;
                queue.offer(new Node(next, current));
                visited[next] = true;
            }
        }
        for (; arrive.pre != null; arrive = arrive.pre) {
            path.addFirst(arrive.now);
        }
        path.addFirst(N);
    }
    public static void main(String[] args) throws IOException {
        input();
        if(N >= K) {
            System.out.println(N - K);
            goBack();
        }
        else {
            solution();
            System.out.println(path.size() - 1);
            while (!path.isEmpty()){
                System.out.print(path.pollFirst() + " ");
            }
        }
    }
}