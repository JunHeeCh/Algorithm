import java.util.*;

class Solution {
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] visited = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && picture[i][j]>0){
                    int size = bfs(visited, picture, i, j);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(size, maxSizeOfOneArea);
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }
    
    public int bfs(boolean[][] visited, int[][] picture, int r, int c){
        // 해당 칸의 사이즈를 반환 
        int size = 1;
        
        int num = picture[r][c];
        
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{r,c});
        visited[r][c] = true;
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            
            for(int i=0; i<dr.length; i++){
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                
                if(nr < 0 || nc < 0 || nr >= picture.length || nc >= picture[0].length || visited[nr][nc] || picture[nr][nc] != num) continue;
                size++;
                queue.add(new int[]{nr,nc});
                visited[nr][nc] = true;
            }
        }
        return size;
    }
}