import java.util.*;

class Solution {
    int[] dr = {-1,1,0,0};
    int[] dc = {0,0,-1,1};
    
    public int solution(String[] bb) {
        int answer = -1;
        int n = bb[0].length();
        int[][] board = new int[bb.length][n];
        boolean[][] visited = new boolean[bb.length][n];
        
        int[] start = new int[3];
        
        for(int i=0; i<bb.length; i++){
            char[] temp = bb[i].toCharArray();
            for(int j=0; j<board[i].length; j++){
                if(temp[j]=='R'){
                    start[0] = i;
                    start[1] = j;
                }else if(temp[j]=='G'){
                    board[i][j] = 100;
                }else if(temp[j] == 'D'){
                    board[i][j] = -1;
                }
            }
        }
        
        Queue<int[]> queue = new LinkedList();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            if(board[now[0]][now[1]]==100){
                answer = now[2];
                break;
            }
            for(int i=0; i<4; i++){
                int[] next = new int[3];
                int[] temp = new int[2];
                temp = move(board, now, i);
                if(visited[temp[0]][temp[1]]) continue;
                next[0] = temp[0];
                next[1] = temp[1];
                next[2] = now[2]+1;
                queue.add(next);
                visited[next[0]][next[1]] = true;
            }
        }
        
        
        return answer;
    }
    
    public int[] move(int[][] board, int[] now, int dir){
        int nr = now[0];
        int nc = now[1];
        
        while(nr>=0 && nr < board.length && nc>=0 && nc <board[0].length && board[nr][nc] != -1){
            nr += dr[dir];
            nc += dc[dir];
        }
        
        return new int[]{nr-dr[dir],nc-dc[dir]};
    }
}