import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        
        // key: "시간,r,c" → 해당 시간/위치에 있는 로봇 수
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < routes.length; i++) {
            int r = points[routes[i][0] - 1][0];
            int c = points[routes[i][0] - 1][1];
            int t = 0;
            
            // 시작 위치 기록
            String key = t + "," + r + "," + c;
            map.put(key, map.getOrDefault(key, 0) + 1);
            
            // 경유지 순서대로 이동
            for (int j = 1; j < routes[i].length; j++) {
                int tr = points[routes[i][j] - 1][0];
                int tc = points[routes[i][j] - 1][1];
                
                // 행 먼저 이동
                while (r != tr) {
                    r += (r < tr) ? 1 : -1;
                    t++;
                    key = t + "," + r + "," + c;
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
                // 열 이동
                while (c != tc) {
                    c += (c < tc) ? 1 : -1;
                    t++;
                    key = t + "," + r + "," + c;
                    map.put(key, map.getOrDefault(key, 0) + 1);
                }
            }
        }
        
        // 2대 이상 겹친 위치(시간 포함) 개수 카운트
        for (int val : map.values()) {
            if (val >= 2) answer++;
        }
        
        return answer;
    }
}