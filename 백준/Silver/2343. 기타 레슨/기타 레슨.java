import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] lecture;
    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lecture = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            lecture[i] = Integer.parseInt(st.nextToken());
        }
    }

    static int count(int capacity){
        int count = 1, sum = 0;
        for(int x : lecture){
            if(sum + x > capacity){
                count++;
                sum = x;
            }
            else
                sum += x;
        }
        return count;
    }


    static int solution(){
        int answer = 0;
        int lt = Arrays.stream(lecture).max().getAsInt();
        int rt = Arrays.stream(lecture).sum();
        while(lt <= rt){
            int mid = (lt + rt) / 2;
            if(count(mid) <= M){
                answer = mid;
                rt = --mid;
            }
            else{
                lt = ++mid;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solution());
    }
}