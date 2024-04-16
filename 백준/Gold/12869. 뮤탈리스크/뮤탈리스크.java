import java.io.*;
import java.util.*;

class SCV{
    int first;
    int second;
    int third;
    int count = 0;
    public SCV(int first, int second, int third, int count) {
        this.first = first;
        this.second = second;
        this.third = third;
        this.count = count;
    }
    public SCV() {}
    public boolean isAllDestroyed(){
        return first <= 0 && second <= 0 && third <= 0;
    }
    public int countSCV(){
        int tmp = 3;
        if (first <= 0) tmp--;
        if(second <= 0) tmp--;
        if(third <= 0) tmp--;
        return tmp;
    }
}
public class Main {
    static int N;
    static SCV scv;
    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        scv = new SCV();
        int[] arr = new int[3];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        scv.first = arr[2];
        scv.second = arr[1];
        scv.third = arr[0];
    }
    static void arrayCheck(int[] arr){
        for(int i = 0; i < 3; i++){
            if(arr[i] < 0)
                arr[i] = 0;
        }
        Arrays.sort(arr);
    }
    static void solution(){
        Queue<SCV> queue = new ArrayDeque<>();
        queue.add(scv);
        int[] arr = new int[3];
        while(!queue.isEmpty()){
            SCV tmp = queue.poll();
            if(tmp.isAllDestroyed()){
                System.out.println(tmp.count);
                break;
            }
            arr[0] = tmp.first - 9;
            arr[1] = tmp.second - 3;
            arr[2] = tmp.third - 1;
            arrayCheck(arr);
            queue.offer(new SCV(arr[2], arr[1], arr[0], tmp.count + 1));
            if(tmp.countSCV() == 3){
                arr[0] = tmp.first - 9;
                arr[1] = tmp.second - 1;
                arr[2] = tmp.third - 3;
                arrayCheck(arr);
                queue.offer(new SCV(arr[2], arr[1], arr[0], tmp.count + 1));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        solution();
    }
}