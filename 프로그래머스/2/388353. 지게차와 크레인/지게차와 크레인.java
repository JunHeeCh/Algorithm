import java.util.*;

class Solution {
    int[] dr = new int[]{-1,1,0,0};
    int[] dc = new int[]{0,0,-1,1};
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        
        int n = storage.length+2; 
        int m = storage[0].length()+2;
        
        answer = (n-2)*(m-2);
        
        int[][] board = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j] = -1;
            }
        }
        
        for(int i=1; i<n-1; i++){
            for(int j=1; j<m-1; j++){
                board[i][j] = storage[i-1].charAt(j-1);
            }
        }
        
        for(int i=0; i<requests.length; i++){
            int a = 0;
            if(requests[i].length()>1){
                // 모두 출고
                a = deleteAll(board,requests[i].charAt(0));
            }else{
                // 가에서 접근 가능한 거 출고 
                a = deletePart(board,requests[i].charAt(0));
            }
            answer -= a;
        }
        
        return answer;
    }
    
    public int deleteAll(int[][] board, char alphabet){
        int count = 0;
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == alphabet){
                    board[i][j] = -1;
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public int deletePart(int[][] board, char alphabet){
        int count = 0;
        List<int[]> deleteList = new ArrayList();
        
        int n = board.length; 
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{0,0});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i=0; i<dr.length; i++){
                int nr = now[0]+dr[i];
                int nc = now[1]+dc[i];
                if(nr<0 || nc <0 || nr >=n || nc >=m || visited[nr][nc]) continue;
                if(board[nr][nc]==-1){
                    queue.add(new int[]{nr,nc});
                }else if(board[nr][nc]==alphabet){
                    deleteList.add(new int[]{nr,nc});
                }
                visited[nr][nc] = true;
            }
        }
        
        count = deleteList.size();
        
        for(int[] now : deleteList){
            board[now[0]][now[1]] = -1;
        }
        
        return count;
    }
}