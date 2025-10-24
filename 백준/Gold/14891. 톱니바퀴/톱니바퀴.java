import java.io.*;
import java.util.*;

class Cogwheel {

    public List<Integer> cog = new ArrayList<>();
    public int left;
    public int right;

    public Cogwheel(String cogs) {
        for (char c : cogs.toCharArray()) {
            cog.add(Character.getNumericValue(c));
        }
        left = cog.get(6);
        right = cog.get(2);
    }

    void 시계방향() {
        Collections.rotate(cog, 1);
        left = cog.get(6);
        right = cog.get(2);
    }

    void 반시계방향() {
        Collections.rotate(cog, -1);
        left = cog.get(6);
        right = cog.get(2);
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Cogwheel> cogwheels = new ArrayList<>(4);
        for (int i = 0; i < 4; i++) {
            Cogwheel cogwheel = new Cogwheel(br.readLine());
            cogwheels.add(cogwheel);
        }

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cogwheelNum = Integer.parseInt(st.nextToken()) - 1;
            int rotateDir = Integer.parseInt(st.nextToken());
            int[] flag = new int[cogwheels.size()];
            int[] L = new int[4];
            int[] R = new int[4];
            for (int i = 0; i < 4; i++) {
                L[i] = cogwheels.get(i).left;
                R[i] = cogwheels.get(i).right;
            }
            flag[cogwheelNum] = rotateDir;
            for (int i = cogwheelNum - 1; i >= 0; i--) {
                if (flag[i + 1] == 0) break;
                if(R[i] == L[i + 1]) break;
                flag[i] = -flag[i + 1];
            }
            for (int i = cogwheelNum + 1; i < cogwheels.size(); i++) {
                if (flag[i - 1] == 0) break;
                if (R[i - 1] == L[i]) break;
                flag[i] = -flag[i - 1];
            }
            for (int i = 0; i < cogwheels.size(); i++) {
                if (flag[i] == 1) 
                    cogwheels.get(i).시계방향();
                else if (flag[i] == -1)
                    cogwheels.get(i).반시계방향();
            }
        }

        int score = 0;
        if (cogwheels.get(0).cog.get(0) == 1) score += 1;
        if (cogwheels.get(1).cog.get(0) == 1) score += 2;
        if (cogwheels.get(2).cog.get(0) == 1) score += 4;
        if (cogwheels.get(3).cog.get(0) == 1) score += 8;

        System.out.println(score);
    }
}