import java.util.*;

class Solution {
    int[] dr = new int[]{-1,1,0,0};
    int[] dc = new int[]{0,0,-1,1};
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        
        int[][] board = new int[maps.length][];
        for(int i=0; i<maps.length; i++){
            char[] temp = maps[i].toCharArray();
            board[i] = new int[temp.length];
            for(int j=0; j<temp.length; j++){
                if(temp[j]=='X'){
                    board[i][j] = -1;
                    continue;
                }
                board[i][j] = temp[j]-'0';
            }
        }
        
        boolean[][] visited = new boolean[board.length][board[0].length];
        List<Integer> list = new ArrayList();
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(visited[i][j] || board[i][j]==-1) continue;
                list.add(bfs(board, i, j, visited));
            }
        }
        if(list.isEmpty()){
            answer = new int[]{-1};
        }else{
            answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) answer[i] = list.get(i);
            Arrays.sort(answer); 
        }
        

        return answer;
    }
    
    public int bfs(int[][] board, int i, int j, boolean[][] visited){
        Queue<int[]>queue = new LinkedList();
        queue.add(new int[]{i,j});
        visited[i][j] = true;
        
        int sum = board[i][j];
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int k=0; k<dr.length; k++){
                int nr = now[0] +dr[k];
                int nc = now[1] +dc[k];
                
                if(nr < 0 || nc < 0 || nr >= board.length || nc >= board[0].length || visited[nr][nc] || board[nr][nc]==-1){
                    continue;
                }
                visited[nr][nc] = true;
                queue.add(new int[]{nr,nc});
                sum += board[nr][nc];
            }
            
        }
        
        return sum;
    }
    
}