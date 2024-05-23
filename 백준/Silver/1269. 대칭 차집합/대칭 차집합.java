import java.io.*;
import java.util.*;
/**
 * 접근 방식
 *
 * 처음 든 생각은 수학적으로 접근
 * 집합 A를 담아 둘 임시 집합 tmp를 만들고,
 * A - B, B - tmp 해서 단순히 사이즈를 더함
 * 
 * 그런데 이것보다 입력 받을 때 map을 하나 만들어 원소를 키로, 개수를 값으로 함
 * 더 나아가, 만약 같은 숫자를 입력하면 그 키를 삭제해버리고
 * 마지막에 map의 크기만을 반환하면 되겠다 생각
 * 
 */
public class Main {
    static Map<Integer, Integer> result = new HashMap<>();
    static int a, b;

    static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(result.containsKey(num)){
                result.remove(num);
                continue;
            }
            result.put(num, result.getOrDefault(num, 0) + 1);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(result.containsKey(num)){
                result.remove(num);
                continue;
            }
            result.put(num, result.getOrDefault(num, 0) + 1);
        }
        System.out.println(result.size());
    }

    public static void main(String[] args) throws IOException {
        input();
    }
}
