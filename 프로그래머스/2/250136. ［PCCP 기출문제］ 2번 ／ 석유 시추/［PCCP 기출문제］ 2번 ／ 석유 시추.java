import java.util.*;

class Solution {
    Map<Integer, Integer> map = new HashMap(); // 번호, 석유 크기 
    int idx;
    int[] dr = new int[]{-1,1,0,0};
    int[] dc = new int[]{0,0,-1,1};
    
    public int solution(int[][] land) { // 1이면 석유
        int answer = 0;
        
        idx = -1;
        
        boolean[][] visited = new boolean[land.length][land[0].length];
        
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    bfs(land, visited, i, j);
                    idx--;
                }
            }
        }
        
        for(int j=0; j<land[0].length; j++){
            int total = 0;
            Set<Integer> set = new HashSet();
            
            for(int i=0; i<land.length; i++){
                if(land[i][j]<0 && !set.contains(land[i][j])){
                    total += map.get(land[i][j]);
                    set.add(land[i][j]);
                }
            }
            
            answer = Math.max(answer, total);
        }
        return answer;
    }
    
    public void bfs(int[][] land, boolean[][] visited, int r, int c){
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{r,c});
        visited[r][c] = true;
        land[r][c] = idx;
        
        int count = 1;
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i=0; i<dr.length; i++){
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                if(nr < 0 || nc < 0 || nr >= land.length || nc >= land[0].length || visited[nr][nc]) continue;
                if(land[nr][nc]==1){
                    queue.add(new int[]{nr,nc});
                    visited[nr][nc] = true;
                    land[nr][nc] = idx;
                    count++;
                }
            }
        }
        map.put(idx, count);
        return;
    }
}