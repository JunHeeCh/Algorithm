/*
출입구 - 산봉우리 - 출입구(시작 위치에서 이용한) 
위 코스를 설계하는데, 가장 긴 이동거리가 최소가 되도록 

*/

import java.util.*;

class Solution {
    
    int min = Integer.MAX_VALUE;
    int idx = Integer.MAX_VALUE;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        List<int[]>[] list = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList();
        }
        
        for(int i=0; i<paths.length; i++){
            int a = paths[i][0];
            int b = paths[i][1];
            int c = paths[i][2];
            
            list[a].add(new int[]{b,c});
            list[b].add(new int[]{a,c});
        }
        
        Set<Integer> set = new HashSet();
        for(int i=0; i<summits.length; i++){
            set.add(summits[i]);
        }
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));
        
        
        for(int i=0; i<gates.length; i++){
            pq.add(new int[]{gates[i], 0});
            dist[gates[i]] = 0;
        }

        while(!pq.isEmpty()){
            int[] now = pq.poll();
            
            if(set.contains(now[0])){
                if(min > now[1]){
                    min = now[1];
                    idx = now[0];
                }else if(min==now[1]){
                    idx = Math.min(idx, now[0]);
                }
                continue;
            }
            
            if(dist[now[0]] < now[1]) continue;
            
            for(int[] next : list[now[0]]){
                int cost = Math.max(now[1], next[1]);
                if(dist[next[0]] > cost){
                    dist[next[0]] = cost;
                    pq.add(new int[]{next[0], cost});
                }
            }
        }
        
        int[] answer = new int[]{idx, min};
        return answer;
    }
    

}