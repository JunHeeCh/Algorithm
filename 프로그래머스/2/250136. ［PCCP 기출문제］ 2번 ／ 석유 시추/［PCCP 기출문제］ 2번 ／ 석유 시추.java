import java.util.*;

class Solution {

    int[] dr = new int[]{-1,1,0,0};
    int[] dc = new int[]{0,0,-1,1};
    int[] arr;
    
    public int solution(int[][] land) { // 1이면 석유
        int answer = 0;
        
        // 1. 우선 bfs로 각 땅 별 석유의 크기를 계산한다 
        // 1-1. 이때, 가장 왼쪽 땅 위치와 오른쪽 땅 위치를 가지고, 해당 땅의 위치에 석유 크기를 저장한다 
        int n = land.length; 
        int m = land[0].length;
        arr = new int[m];
        
        boolean[][] visited = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j]==1 && !visited[i][j]){
                    bfs(land, visited, i, j);
                }
            }
        }
        
        // 2. 가로 길이를 돌면서 최대값을 찾는다 
        for(int i=0; i<m; i++){
            answer = Math.max(answer, arr[i]);
        }
        return answer;
    }
    
    public void bfs(int[][] land, boolean[][] visited, int r, int c){
        int[] now = new int[]{r,c};
        Queue<int[]> queue = new LinkedList();
        queue.add(now);
        visited[r][c] = true;
        
        int size = 1;
        int left = c;
        int right = c;
        while(!queue.isEmpty()){
            now = queue.poll();
            
            for(int i=0; i<dr.length; i++){
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                
                if(nr<0 || nr >=land.length || nc <0 || nc >= land[0].length || land[nr][nc] == 0 || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                queue.add(new int[]{nr,nc});
                size++;
                left = Math.min(left, nc);
                right = Math.max(right, nc);
            }
        }
        
        for(int i=left; i<=right; i++){
            arr[i] += size;
        }
        
    }
    
}