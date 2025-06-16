import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Truck{
    int w;
    int startTime;

    public Truck(int w, int startTime) {
        this.w = w;
        this.startTime = startTime;
    }
}

public class Main {

    static Queue<Integer> trucks = new LinkedList<>();
    static Queue<Truck> bridge = new LinkedList<>();
    static int currentTime = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 트럭 수
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        int L = Integer.parseInt(st.nextToken()); // 최대 하중

        // 트럭의 무게 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            trucks.add(Integer.parseInt(st.nextToken()));
        }

        while (!trucks.isEmpty()) {
            currentTime++;
            if(!bridge.isEmpty()){ // 다리 위에 트럭이 있으면 맨 앞에 있는 트럭의 시간을 출발 시간과 비교해 다리를 완전히 건넌 상태인지 확인한다.
                Truck truck = bridge.peek();
                if(currentTime - truck.startTime == w) {
                    bridge.poll();
                }
            }
            int readyTruckWeight = trucks.peek();
            if(bridge.size() + 1 <= w &&
                    getCurrentTotalWeightsInBridge() + readyTruckWeight <= L){ // 대기중인 트럭들 중 맨 앞 트럭이 다리위를 건너기 시작할 수 있는가?
                bridge.offer(new Truck(trucks.poll(), currentTime));
            }
        }

        // 트럭 대기열에 트럭이 없으면 while 종료 후 마지막 currentTime + w를 하면 최종 결과가 나옴
        System.out.println(currentTime + w);
    }

    static int getCurrentTotalWeightsInBridge(){
        int currentTotalWeightsInBridge = 0;
        for(Truck truck : bridge){
            currentTotalWeightsInBridge += truck.w;
        }
        return currentTotalWeightsInBridge;
    }
}