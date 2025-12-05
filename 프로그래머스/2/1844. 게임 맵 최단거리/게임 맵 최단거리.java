import java.util.*;

class Solution {
    static int[] dr = new int[]{-1,1,0,0};
    static int[] dc = new int[]{0,0,-1,1};
    
    public int solution(int[][] maps) {
        int answer = -1;
        
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{0,0,1});
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            
            if(now[0]==n-1 && now[1] == m-1){
                answer = now[2];
                break;
            }
            
            for(int i=0; i<dr.length; i++){
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if(nr <0 || nc < 0 || nr >= n || nc >= m || visited[nr][nc] || maps[nr][nc]==0){
                    continue;
                }
                
                queue.add(new int[]{nr,nc, now[2]+1});
                visited[nr][nc] = true;
            }
        }
        
        return answer;
    }
}