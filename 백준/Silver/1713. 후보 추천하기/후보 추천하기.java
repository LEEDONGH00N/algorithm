import java.util.*;
import java.io.*;

class Node {
    int student_num;
    int count;
    int order;

    public Node(int student_num, int order) {
        this.student_num = student_num;
        this.count = 1;
        this.order = order;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int recommends = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < recommends; i++) {
            int num = Integer.parseInt(st.nextToken());
            boolean exists = false;

            for (Node node : list) {
                if (node.student_num == num) {
                    node.count++;
                    exists = true;
                    break;
                }
            }
            
            if (!exists) {
                if (list.size() == N) {
                    list.sort((n1, n2) -> {
                        if (n1.count != n2.count) {
                            return Integer.compare(n1.count, n2.count);
                        }
                        return Integer.compare(n1.order, n2.order);
                    });
                    list.remove(0);
                }
                list.add(new Node(num, i));
            }
        }
        list.sort((n1, n2) -> Integer.compare(n1.student_num, n2.student_num));

        for (Node n : list) {
            System.out.print(n.student_num + " ");
        }
    }
}