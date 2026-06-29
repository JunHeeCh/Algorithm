import java.util.*;

class Solution {
    public long solution(int[] a, int[][] edges) {
        long answer = 0;
        
        int n = a.length;
        long[] arr = new long[n];
        
        long sum = 0;
        for(int i=0; i<n; i++){
            sum += a[i];
            arr[i] = a[i];
        }
        
        if(sum != 0){
            return -1;
        }
        
        List<Integer>[] list = new ArrayList[n];
        for(int i=0; i<n; i++){
            list[i] = new ArrayList();
        }
        
        int[] degree = new int[n];
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            list[u].add(v);
            list[v].add(u);
            degree[u]++;
            degree[v]++;
        }
        
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque();
        for(int i=0; i<n; i++){
            if(degree[i]==1) queue.add(i);
        }
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            
            if(degree[now]==0) continue;
            
            int target = 0;
            
            for(int i : list[now]){
                if(!visited[i]) {
                    target = i;
                    break;
                }
            }
            answer += Math.abs(arr[now]); // 횟수 추가
            arr[target] += arr[now]; // 값 반영
            degree[now]--;
            degree[target]--;
            if(degree[target]==1){
                queue.add(target);
            }
            visited[now] = true;
        }
        return answer;
    }

}