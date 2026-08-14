import java.util.*;

class Solution {

    int[] dr = new int[]{-1,1,0,0};
    int[] dc = new int[]{0,0,-1,1};
    int[] oil;
    
    public int solution(int[][] land) { 
        int answer = 0;
        
        boolean[][] visited = new boolean[land.length][land[0].length];
        oil = new int[land[0].length];
        
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                if(land[i][j]==1 && !visited[i][j]){
                    visited[i][j] = true;
                    bfs(land, visited, i, j);
                }
            }
        }
        
        for(int i=0; i<oil.length; i++){
            answer = Math.max(answer, oil[i]);
        }
        return answer;
    }
    
    public void bfs(int[][] land, boolean[][] visited, int r, int c){
        Set<Integer> set = new HashSet();
        set.add(c);
        int territory = 1;
        
        Queue<int[]> queue = new ArrayDeque();
        queue.add(new int[]{r,c});
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            
            for(int i=0; i<4; i++){
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                if(nr < 0 || nc < 0 || nr >= land.length || nc >= land[0].length || land[nr][nc]==0 || visited[nr][nc]) continue;
                queue.add(new int[]{nr,nc});
                territory++;
                visited[nr][nc] = true;
                set.add(nc);
            }
        }
        
        for(int i:set){
            oil[i] += territory;
        }
    }
    
}