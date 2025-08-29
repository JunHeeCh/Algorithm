import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<visited.length; i++){
            if(!visited[i]){
                bfs(visited, computers, i);
                answer++;
            }
        }
        return answer;
    }
    
    public void bfs(boolean[] visited, int[][] computers, int idx){
        visited[idx] = true;
        
        Queue<Integer> queue = new LinkedList();
        queue.add(idx);
        
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int i=0; i<computers[0].length; i++){
                if(computers[now][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }   
        }

    }
}