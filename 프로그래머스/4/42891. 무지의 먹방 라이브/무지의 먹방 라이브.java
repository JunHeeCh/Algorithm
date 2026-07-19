import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        int n = food_times.length;
        
        // 총 먹는데 걸리는 시간이 k 이하라면 다 먹고 끝남
        long total = 0;
        for (int t : food_times) total += t;
        if (total <= k) return -1;
        
        // (시간, 원래번호) 페어를 시간 기준 정렬
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        Arrays.sort(idx, (a, b) -> food_times[a] - food_times[b]);
        
        long prevTime = 0;
        int remaining = n; // 아직 다 안 먹은 음식 개수
        
        for (int i = 0; i < n; i++) {
            int curTime = food_times[idx[i]];
            long diff = (long)(curTime - prevTime) * remaining;
            
            if (k < diff) {
                // 이 구간 안에서 답이 나옴
                // idx[i..n-1] 을 원래 번호 기준으로 정렬해서 순환
                List<Integer> left = new ArrayList<>();
                for (int j = i; j < n; j++) left.add(idx[j] + 1); // 1-indexed
                Collections.sort(left);
                
                int pos = (int)(k % remaining);
                return left.get(pos);
            }
            
            k -= diff;
            remaining--;
            prevTime = curTime;
        }
        
        return -1; // 도달할 일 없음 (위에서 total<=k로 이미 걸러짐)
    }
}