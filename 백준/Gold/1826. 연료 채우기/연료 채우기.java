import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        
        station[] gas = new station[N];
        
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().trim().split(" ");
            int a = Integer.parseInt(temp[0]);
            int b = Integer.parseInt(temp[1]);
            gas[i] = new station(a, b);
        }
        
        String[] temp = br.readLine().trim().split(" ");
        int L = Integer.parseInt(temp[0]);
        int P = Integer.parseInt(temp[1]);
        
        // 위치순으로 정렬
        Arrays.sort(gas, (a, b) -> Integer.compare(a.x, b.x));
        
        // 최대 힙 (연료량 기준)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        int currentPos = 0;
        int currentFuel = P;
        int stationIndex = 0;
        int refuelCount = 0;
        
        while (currentPos + currentFuel < L) {
            // 현재 연료로 갈 수 있는 주유소들을 모두 큐에 추가
            while (stationIndex < N && gas[stationIndex].x <= currentPos + currentFuel) {
                pq.offer(gas[stationIndex].fuel);
                stationIndex++;
            }
            
            // 갈 수 있는 주유소가 없으면 실패
            if (pq.isEmpty()) {
                System.out.println(-1);
                return;
            }
            
            // 가장 연료가 많은 주유소에서 주유
            currentFuel += pq.poll();
            refuelCount++;
        }
        
        System.out.println(refuelCount);
    }
}

class station {
    int x;
    int fuel;
    
    public station(int x, int fuel) {
        this.x = x;
        this.fuel = fuel;
    }
}