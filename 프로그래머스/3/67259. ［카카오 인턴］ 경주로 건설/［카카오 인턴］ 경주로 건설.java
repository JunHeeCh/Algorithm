import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int n = board.length;
        
        int[][][] visited = new int[n][n][4];
        
        for(int[][] layer : visited) {
            for(int[] row : layer) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }
        
        int[] dr = new int[]{-1,0,1,0};//상좌하우
        int[] dc = new int[]{0,-1,0,1};
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[3] - b[3]);
        pq.add(new int[]{0,0, -1, 0}); // r,c,방향, 금액
        
        int min = Integer.MAX_VALUE;
        
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            
            if(now[0] == n-1 && now[1] == n-1){
                min = Math.min(min, now[3]);
                continue;
            }
            
            if(now[2] != -1 && now[3] > visited[now[0]][now[1]][now[2]]) {
                continue;
            }
            
            for(int i=0; i<dr.length; i++){
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                
                if(nr < 0 || nc < 0 || nr >= n || nc >= n || board[nr][nc] == 1){
                    continue;
                }
                
                int cost;
                if(now[2]==-1){
                    cost = 100;
                }else{
                    if(now[2] == i){
                        cost = 100;
                    }else{
                        cost = 600;
                    }
                }
                
                cost += now[3];
                if(cost < visited[nr][nc][i]){
                    visited[nr][nc][i] = cost;
                    pq.add(new int[]{nr,nc,i,cost});
                }
                
            }
        }
        
        return min;
    }
}