import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] A;
    static int[][] nutrients;
    static Deque<Integer>[][] trees;
    static final int[] dx = {-1,-1,-1,0,0,1,1,1};
    static final int[] dy = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N][N];
        nutrients = new int[N][N];
        trees = new ArrayDeque[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(nutrients[i], 5);
            for (int j = 0; j < N; j++) trees[i][j] = new ArrayDeque<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) A[i][j] = Integer.parseInt(st.nextToken());
        }

        List<Integer>[][] tmp = new ArrayList[N][N];
        for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) tmp[i][j] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int age = Integer.parseInt(st.nextToken());
            tmp[x][y].add(age);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Collections.sort(tmp[i][j]);
                for (int a : tmp[i][j]) trees[i][j].addLast(a);
            }
        }

        while (K-- > 0) {
            springAndSummer();
            autumn();
            winter();
        }

        int answer = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                answer += trees[i][j].size();

        System.out.println(answer);
    }

    static void springAndSummer() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (trees[i][j].isEmpty()) continue;
                Deque<Integer> cur = trees[i][j];
                Deque<Integer> next = new ArrayDeque<>(cur.size());
                int avail = nutrients[i][j];
                int dead = 0;
                while (!cur.isEmpty()) {
                    int age = cur.pollFirst();
                    if (age <= avail) {
                        avail -= age;
                        next.addLast(age + 1);
                    } else {
                        dead += age / 2;
                    }
                }
                trees[i][j] = next;
                nutrients[i][j] = avail + dead;
            }
        }
    }

    static void autumn() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (trees[i][j].isEmpty()) continue;
                for (int age : trees[i][j]) {
                    if (age % 5 != 0) continue;
                    for (int d = 0; d < 8; d++) {
                        int nx = i + dx[d], ny = j + dy[d];
                        if (0 <= nx && nx < N && 0 <= ny && ny < N)
                            trees[nx][ny].addFirst(1);
                    }
                }
            }
        }
    }

    static void winter() {
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                nutrients[i][j] += A[i][j];
    }
}