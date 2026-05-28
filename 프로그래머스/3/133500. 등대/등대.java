import java.util.*;

class Solution {
    static List<Integer>[] list;
    static boolean[] visited;
    static int[][] dp;
    
    public int solution(int n, int[][] lighthouse) {
        int answer = 0;
        
        list = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++){
            list[i] = new ArrayList();
        }
        
        for(int i=0; i<lighthouse.length; i++){
            int a = lighthouse[i][0];
            int b = lighthouse[i][1];
            list[a].add(b);
            list[b].add(a);
        }
        
        visited = new boolean[n+1];
        
        dp = new int[n+1][2];
        
        dfs(1);
        
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    public void dfs(int v){
        visited[v] = true;
        dp[v][0] = 0;
        dp[v][1] = 1;
        
        for(int next : list[v]){
            if(visited[next]) continue;
            dfs(next);
            
            dp[v][0] += dp[next][1];
            
            dp[v][1] += Math.min(dp[next][0], dp[next][1]);
        }
        
    }
}