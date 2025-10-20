import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        int[] dist = new int[n+1];
        
        for(int i=0; i<n+1; i++){
            dist[i] = -1;
        }
        
        dist[destination] = 0;
        
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{destination, 0});
        
        List<Integer>[] list = new ArrayList[n+1];
        
        for(int i=0; i<=n; i++){
            list[i] = new ArrayList();
        }
        
        for(int i=0; i<roads.length; i++){
            int a = roads[i][0];
            int b = roads[i][1];
            
            list[a].add(b);
            list[b].add(a);
        }
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int node = now[0];
            int cnt = now[1];
            
            for(int i : list[node]){
                if(dist[i] != -1){
                    continue;
                }
                dist[i] = cnt+1;
                queue.add(new int[]{i, cnt+1});
            }
        }

        int[] answer = new int[sources.length];

        for(int i=0; i<sources.length; i++){
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
}