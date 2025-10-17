import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        int[] dist = new int[n+1];
        
        for(int i=1; i<=n; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        
        List<Integer>[] list = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList();
        }
        
        for(int i=0; i<edge.length; i++){
            int a= edge[i][0];
            int b= edge[i][1];
            
            list[a].add(b);
            list[b].add(a);
        }
        
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{1,0});
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int node = now[0];
            int len = now[1];
            
            if(dist[node] != Integer.MAX_VALUE){
                continue;
            }
            
            dist[node] = len;
            for(int i : list[node]){
                queue.add(new int[]{i, len+1});
            }
        }
        
        int max = 0;
        int cnt = 0;
        for(int i=2; i<dist.length; i++){
            if(dist[i] > max){
                max = dist[i];
                cnt = 1;
            }else if(dist[i] == max){
                cnt++;
            }
        }
        
        return cnt;
    }
}