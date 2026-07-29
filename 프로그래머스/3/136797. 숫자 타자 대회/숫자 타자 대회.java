import java.util.*;

class Solution {
    int[] dr = new int[]{0,0,-1,1};
    int[] dc = new int[]{-1,1,0,0};
    int[] ddr = new int[]{-1,1,1,-1};
    int[] ddc = new int[]{1,1,-1,-1};

    Map<Character, Integer> map = new HashMap(); // 문자 -> 0~11 인덱스
    int[][] dist = new int[12][12];

    public int solution(String numbers) {
        char[] keys = {'1','2','3','4','5','6','7','8','9','*','0','#'};
        for(int i=0; i<12; i++){
            map.put(keys[i], i);
        }

        // 자판 12칸끼리의 거리를 미리 다 구해놓는다
        for(int i=0; i<12; i++){
            int[] pi = new int[]{i/3, i%3};
            for(int j=0; j<12; j++){
                int[] pj = new int[]{j/3, j%3};
                dist[i][j] = find(pi, pj);
            }
        }

        int left = map.get('4');
        int right = map.get('6');

        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(left * 12 + right, 0);

        for(int i=0; i<numbers.length(); i++){
            int target = map.get(numbers.charAt(i));

            Map<Integer, Integer> next = new HashMap<>();
            for(Map.Entry<Integer, Integer> e : dp.entrySet()){
                int key = e.getKey();
                int l = key / 12;
                int r = key % 12;
                int cost = e.getValue();

                // 왼손으로 누르는 경우 - 오른손이 이미 target에 있으면 겹치므로 불가
                if (r != target) {
                    int k1 = target * 12 + r;
                    next.merge(k1, cost + dist[l][target], Math::min);
                }

                // 오른손으로 누르는 경우 - 왼손이 이미 target에 있으면 겹치므로 불가
                if (l != target) {
                    int k2 = l * 12 + target;
                    next.merge(k2, cost + dist[r][target], Math::min);
                }
            }
            dp = next;
        }

        int answer = Integer.MAX_VALUE;
        for(int v : dp.values()) answer = Math.min(answer, v);

        return answer;
    }

    public int find(int[] now, int[] target){
        if(now[0]==target[0] && now[1]==target[1]) return 1;

        int res = Math.abs(now[0]-target[0])*2+Math.abs(now[1]-target[1])*2;

        Queue<int[]> queue = new ArrayDeque();
        queue.add(new int[]{now[0], now[1], 0});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(cur[2] >= res) continue;
            if(cur[0]==target[0] && cur[1]==target[1]){
                res = Math.min(res, cur[2]);
                continue;
            }

            for(int i=0; i<4; i++){
                int nr = cur[0]+dr[i];
                int nc = cur[1]+dc[i];
                int nnr = cur[0]+ddr[i];
                int nnc = cur[1]+ddc[i];
                if(nr >= 0 && nr < 4 && nc >= 0 && nc < 3){
                    queue.add(new int[]{nr,nc, cur[2]+2});
                }
                if(nnr >= 0 && nnr < 4 && nnc >= 0 && nnc < 3){
                    queue.add(new int[]{nnr,nnc, cur[2]+3});
                }
            }
        }

        return res;
    }
}