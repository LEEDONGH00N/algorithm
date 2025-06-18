import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {

            int I = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new ArrayDeque<>();
            queue.offer(new int[]{startY, startX, 0});

            visited = new boolean[I][I];
            visited[startY][startX] = true;

            int result = 0;
            while(!queue.isEmpty()) {
                int[] current = queue.poll();
                int cnt = current[2];
                if(current[0] == endY && current[1] == endX) {
                    result = cnt;
                    break;
                }
                for(int j = 0; j < 8; j++) {
                    int ny = current[0] + dy[j];
                    int nx = current[1] + dx[j];
                    if(ny < 0 || ny >= I || nx < 0 || nx >= I || visited[ny][nx]) continue;
                    visited[ny][nx] = true;
                    queue.offer(new int[]{ny, nx, cnt + 1});
                }
            }
            System.out.println(result);
        }
    }
}