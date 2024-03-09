import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean solution(String word){
        char[] tmp = word.toCharArray();

        boolean flag = false;

        //1. 모음 하나 반드시 포함
        for(char t : tmp){
            if(t == 'a' || t == 'e' || t == 'i' || t == 'o' || t == 'u') {
                flag = true;
                break;
            }
        }
        if(!flag)
            return false;
        //2. 모음이 3개 연속 혹은 자음이 3개 연속으로 오면 안됨
        for(int i = 0; i < tmp.length-2; i++){
            char a = tmp[i];
            char b = tmp[i+1];
            char c = tmp[i+2];
            if((a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u') &&
                    (b == 'a' || b == 'e' || b == 'i' || b == 'o' || b == 'u') &&
                    (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')){
                return false;
            }
            if((a != 'a' && a != 'e' && a != 'i' && a != 'o' && a != 'u') &&
                    (b != 'a' && b != 'e' && b != 'i' && b != 'o' && b != 'u') &&
                    (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u')){
                return false;
            }
        }

        //3. 같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용
        for(int i = 0; i < tmp.length-1; i++){
            char a = tmp[i];
            char b = tmp[i+1];
            if(a == b){
                if(a != 'e' && a != 'o')
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String word = br.readLine();
            if(word.equals("end"))
                break;
            if(solution(word))
                System.out.println("<" + word + "> is acceptable.");
            else
                System.out.println("<" + word + "> is not acceptable.");
        }

    }
}
