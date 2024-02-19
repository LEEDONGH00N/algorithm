package Mathmatics;

import java.util.*;

public class num2108 {
    static void solution(int[] array){
        //산술평균
        double sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
        System.out.println(Math.round(sum / array.length));
        //중앙값
        System.out.println(array[array.length/2]);
        //최빈값
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int k : array){
            map.put(k, map.getOrDefault(k, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));

        int max = entryList.get(0).getValue();
        Iterator<Map.Entry<Integer, Integer>> iterator = entryList.iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() != max) {
                iterator.remove();
            }
        }
        if(entryList.size() == 1)
            System.out.println(entryList.get(0).getKey());
        else
            System.out.println(entryList.get(1).getKey());

        //범위
        if(array.length == 1)
            System.out.println("0");
        else
            System.out.println(array[array.length-1] - array[0]);

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        solution(array);
    }
}
