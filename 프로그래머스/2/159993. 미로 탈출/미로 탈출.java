import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        
        int[][] board = new int[maps.length][]; // 0이면 통로, -1이면 벽, 10이면 레버, 100이면 골인 
        int[] now = new int[3];
        int[] lever = new int[3];
        
        for(int i=0; i<maps.length; i++){
            char[] temp = maps[i].toCharArray();
            board[i] = new int[temp.length];
            for(int j=0; j<temp.length; j++){
                if(temp[j]=='S'){
                    now[0] = i;
                    now[1] = j;
                    now[2] = 0;
                }else if(temp[j]=='E'){
                    board[i][j] = 100;
                }else if(temp[j]=='L'){
                    board[i][j] = 10;
                    lever[0] = i;
                    lever[1] = j;
                    lever[2] = 0;
                }else if(temp[j]=='X'){
                    board[i][j] = -1;
                }
                
            }
        }
        
        Queue<int[]> queue = new LinkedList();
        queue.add(now);
        
        int n = board.length;
        int m = board[0].length;
        
        boolean[][] visited = new boolean[n][m];
        visited[now[0]][now[1]] = true;
        
        int[] dr = new int[]{-1,1,0,0};
        int[] dc = new int[]{0,0,-1,1};
        
        boolean flagA = false;
        boolean flagB = false;
        
        while(!queue.isEmpty()){
            now = queue.poll();
            
            if(board[now[0]][now[1]]==10){
                //레버 도착
                answer += now[2];
                flagA = true;
                break;
            }
            
            for(int i=0; i<dr.length; i++){
                int nr = now[0] +dr[i];
                int nc = now[1] +dc[i];
                if(nr<0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc] || board[nr][nc]==-1){
                    continue;
                }
                queue.add(new int[]{nr,nc,now[2]+1});
                visited[nr][nc] = true;
            }
        }
        
        queue = new LinkedList();
        queue.add(lever);
        
        visited = new boolean[n][m];
        visited[lever[0]][lever[1]] = true;
        
        while(!queue.isEmpty()){
            now = queue.poll();
            
            if(board[now[0]][now[1]]==100){
                //출구 도착
                answer += now[2];
                flagB = true;
                break;
            }
            
            for(int i=0; i<dr.length; i++){
                int nr = now[0] +dr[i];
                int nc = now[1] +dc[i];
                if(nr<0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc] || board[nr][nc]==-1){
                    continue;
                }
                queue.add(new int[]{nr,nc,now[2]+1});
                visited[nr][nc] = true;
            }
        }
        
        if(!flagA || !flagB) answer = -1;
        return answer;
    }
}