class Solution {
    int MOD = 20170805;
    int[] dr = {-1, 0};
    int[] dc = {0, -1};
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        
        int[][] board = new int[m][n];
        
        board[0][0] = 1;
        for(int j=1; j<n; j++){
             board[0][j] = cityMap[0][j] == 1 ? 0 : board[0][j-1];
        }
        for(int i=1; i<m; i++){
            board[i][0] = cityMap[i][0] == 1 ? 0 : board[i-1][0];
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(cityMap[i][j]==1) continue;
                int up = 0, left = 0;
                // 위쪽 확인
                if(cityMap[i-1][j]==2){
                    up = move(board, cityMap, 0, i, j);
                }else{
                    up = board[i-1][j];
                }
                // 좌측 확인 
                if(cityMap[i][j-1]==2){
                    left = move(board, cityMap, 1, i, j);
                }else{
                    left = board[i][j-1];
                }
                board[i][j] = up+left;
                board[i][j] %= MOD;
            }
        }
        return board[m-1][n-1];
    }
    
    public int move(int[][] board, int[][] cityMap, int dir, int r, int c){
        int nr = r+dr[dir];
        int nc = c+dc[dir];
        
        while(nr>=0 && nc >=0){
            if(cityMap[nr][nc] != 2){
                return board[nr][nc];
            }
            
            nr += dr[dir];
            nc += dc[dir];
        }
        
        return 0;
    }
}