class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int dist = Math.abs(x - r) + Math.abs(y - c);
        
        // impossible 조건 2가지
        if (dist > k || (k - dist) % 2 != 0) {
            return "impossible";
        }
        
        // d, l, r, u 순서 (사전순)
        int[] dr = {1, 0, 0, -1};
        int[] dc = {0, -1, 1, 0};
        char[] dir = {'d', 'l', 'r', 'u'};
        
        StringBuilder sb = new StringBuilder();
        
        int cx = x, cy = y;
        for (int step = k; step > 0; step--) {
            for (int i = 0; i < 4; i++) {
                int nx = cx + dr[i];
                int ny = cy + dc[i];
                
                if (nx < 1 || nx > n || ny < 1 || ny > m) continue;
                
                int newDist = Math.abs(nx - r) + Math.abs(ny - c);
                int remaining = step - 1;
                
                // 남은 거리가 남은 이동 횟수 이하이고, 홀짝이 맞으면 선택
                if (newDist <= remaining && (remaining - newDist) % 2 == 0) {
                    sb.append(dir[i]);
                    cx = nx;
                    cy = ny;
                    break;
                }
            }
        }
        
        return sb.toString();
    }
}