import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        int size = s.length();
        
        Stack<Character> stack = new Stack<>();
        List<List<Integer>> tuples = new ArrayList<>();   
        
        int num = 0, t = 0;
        
        for(int i = 0; i < s.length(); i++){
            if (i == 0 || i == s.length() - 1) continue;
            Character cur = s.charAt(i);
            if (cur == '{') {
                stack.push('{');
                if (tuples.size() <= t) {
                    tuples.add(new ArrayList<>());
                }
            }
            else if (cur == '}') {
                if(num != 0) tuples.get(t).add(num);
                num = 0;
                t++;
                stack.pop();
            }
            else if (Character.isDigit(cur)){
                num = num * 10 
                    + Integer.parseInt(Character.toString(cur));
            }
            else if(cur == ','){
                if(stack.isEmpty()) continue;
                tuples.get(t).add(num);
                num = 0;
            }
            
        }
        tuples.sort((a, b) -> a.size() - b.size());
        List<Integer> answer = new ArrayList<>();
        for(List<Integer> list : tuples){
            if(answer.isEmpty()){
                answer.add(list.get(0));
                continue;
            }
            for(int tmp : list){
                if(!answer.contains(tmp))
                    answer.add(tmp);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}