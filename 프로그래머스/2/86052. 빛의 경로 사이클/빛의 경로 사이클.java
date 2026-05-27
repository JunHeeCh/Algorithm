import java.util.*;

class Solution {
    
    // 우 상 좌 하
    int[] dr = new int[]{0,-1,0,1};
    int[] dc = new int[]{1,0,-1,0};
    List<Integer> list = new ArrayList();
    
    public int[] solution(String[] grid) {
        
        // 모든 노드에서 4방향으로 입출이 있어야만 완료된 거 
        
        // 시작한 점으로 다시 돌아올 때까지의 거리를 저장
        // 이전 방향 + 현 위치의 방향 -> 다음 칸으로의 경로 
        
        int n = grid.length;
        int m = grid[0].length();
        
        char[][] board = new char[n][m];
        for(int i=0; i<n; i++){
            char[] temp = grid[i].toCharArray();
            for(int j=0; j<m; j++){
                board[i][j] = temp[j];
            }
        }
        
        boolean[][][] visited = new boolean[n][m][4]; // 우상좌하
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                for(int k=0; k<4; k++){
                    if(!visited[i][j][k]){
                        move(board, visited, i,j,k, 0);
                    }
                }
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        return answer;
    }
    
    public void move(char[][] board, boolean[][][] visited, int r, int c, int dir, int cnt){
        
        int n = board.length; 
        int m = board[0].length;
        int[] init = new int[]{r,c,dir};
                
        int[] now = new int[]{r,c};
        visited[r][c][dir] = true;
        
        while(true){
            
            // 이전 방향은 dir이고, 전환하는 값은 board[r][c]일 때 다음 방향 계산
            switch(board[now[0]][now[1]]){
                case 'L':
                    dir = (dir+1)%4;
                    break;
                case 'R':
                    dir = (dir+3)%4;
                    break;
                default:
                    break;
            }

            int nr = now[0]+dr[dir];
            int nc = now[1]+dc[dir];

            if(nr<0){
                nr += n;
            }
            if(nc<0){
                nc += m;
            }
            if(nr >= n){
                nr -= n;
            }
            if(nc >= m){
                nc -= m;
            }
            
            if(init[0]==nr&&init[1]==nc&&init[2]==dir){
                list.add(cnt+1);
                break;
            }
            
            if(visited[nr][nc][dir]){
                break;
            }
            
            visited[nr][nc][dir] = true;
            now = new int[]{nr,nc};
            cnt++;
        }
        
        
        
        
    }
}