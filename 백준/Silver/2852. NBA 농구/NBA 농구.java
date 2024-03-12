import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int team1_leadTime = 0; static int team2_leadTime = 0;
    static int[] pre_scores = new int[3]; static int[] current_scores = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int tmp = 0; int time = 0;
        while(N--> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int scoredTeam = Integer.parseInt(st.nextToken());
            String scoredTime = st.nextToken();
            int scoredTime_min = Integer.parseInt(scoredTime.substring(0, 2));
            int scoredTime_sec = Integer.parseInt(scoredTime.substring(3));
            time = scoredTime_min * 60 + scoredTime_sec;
            current_scores[scoredTeam]++;

            if(scoredTeam == 1){
                if(current_scores[1] > current_scores[2]){
                    if (pre_scores[1] == pre_scores[2]) {
                        tmp = time;
                    }
                }
                else if (current_scores[1] == current_scores[2])
                    team2_leadTime += time - tmp;
            }

            else if (scoredTeam == 2){
                if (current_scores[1] < current_scores[2]){
                    if (pre_scores[1] == pre_scores[2])
                        tmp = time;
                }
                else if (current_scores[1] == current_scores[2])
                    team1_leadTime += time - tmp;
            }

            pre_scores[scoredTeam]++;
        }
        if (current_scores[1] > current_scores[2])
            team1_leadTime += 48 * 60 - tmp;
        else if (current_scores[1] < current_scores[2])
            team2_leadTime += 48 * 60 - tmp;

        System.out.printf("%02d:%02d\n%02d:%02d\n",team1_leadTime/60,team1_leadTime%60,team2_leadTime/60,team2_leadTime%60);

    }
}
