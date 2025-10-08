import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] board = new int[n][m];
        
        for(int i=0; i<puddles.length; i++){
            int a = puddles[i][0];
            int b = puddles[i][1];
            
            board[b-1][a-1] = -1;   // 웅덩이는 -1 
        }
        
        board[0][0] = 1;
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==-1){
                    continue;
                }
                
                if(i>0 && board[i-1][j] != -1){
                    board[i][j] += board[i-1][j];
                }
                
                if(j>0 && board[i][j-1] != -1){
                    board[i][j] += board[i][j-1];
                }
                board[i][j] %= 1000000007;
            }
        }

        return board[n-1][m-1];
    }
}