import java.util.*;

class Solution {
    int[] dr = new int[]{1,-1,0,0};
    int[] dc = new int[]{0,0,-1,1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int i=0; i<5; i++){
            // places[i] 는 하나의 대기실 구조
            answer[i] = check(places[i]);
        }
        return answer;
    }
    
    public int check(String[] place){
        int[][] board = new int[5][];
        
        for(int i=0; i<place.length; i++){
            char[] temp = place[i].toCharArray();
            board[i] = new int[temp.length];
            for(int j=0; j<temp.length; j++){
                if(temp[j]=='P'){
                    board[i][j] = 1;
                }else if(temp[j]=='X'){
                    board[i][j] = -1;
                }
            }
        }
        
        // 보드에서 맨해튼 거리가 2를 지키는지 확인 
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==1){
                    // 사람 발견 -> 거리 2 이하에 사람이 있는지 확인 
                    if(!find(i,j,board)){
                        return 0;
                    }
                }
            }
        }
        
        return 1;
    }
    
    public boolean find (int r, int c, int[][] board){
        boolean[][] visited = new boolean[board.length][board[0].length];
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{r,c,0});
        visited[r][c] = true;
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            
            if(now[2]>1) continue;
            
            for(int i=0; i<dr.length; i++){
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                if(nr <0 || nc <0 || nr >= board.length || nc >= board[0].length || visited[nr][nc] || board[nr][nc]==-1) continue;
                
                if(board[nr][nc]==1){
                    return false;
                }                
                
                queue.add(new int[]{nr,nc,now[2]+1});
                visited[nr][nc] = true;
            }
        }
        return true;
    }
}