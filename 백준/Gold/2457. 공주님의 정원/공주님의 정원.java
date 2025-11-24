import java.io.*;
import java.util.*;


public class Main {

    static int[] daysInMonth = {0,
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
    };
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int start_date_month = 3;
        int start_date_day = 1;
        int end_date_month = 11;
        int end_date_day = 30;

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new int[]{a, b, c, d});
        }
        list.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            if (a[2] != b[2]) return a[2] - b[2];
            return a[3] - b[3];
        });
        int targetEnd = dayOfYear(end_date_month, end_date_day); 
        int current = dayOfYear(start_date_month, start_date_day);
        int index = 0;
        int count = 0;
        while (current <= targetEnd) {
            int maxEnd = current;   
            boolean found = false;
            while (index < list.size()) {
                int[] flower = list.get(index);
                int flowerStart = dayOfYear(flower[0], flower[1]);
                int flowerEnd = dayOfYear(flower[2], flower[3]);
                if (flowerStart > current) break;
                if (flowerEnd > maxEnd) {
                    maxEnd = flowerEnd;
                    found = true;
                }
                index++;
            }
            if (!found) {
                System.out.println(0);
                return;
            }
            count++;
            current = maxEnd;
            if (current > targetEnd) break;
        }
        System.out.println(count);
    }
    static int dayOfYear(int month, int day) {
        int sum = 0;
        for (int i = 1; i < month; i++) 
            sum += daysInMonth[i];
        return sum + day;
    }
}