import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        
        int[][] board = new int[N+1][N+1];
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(i==j) continue;
                board[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for(int i=0; i<road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int c = road[i][2];
            if(board[a][b] > c){
                board[a][b] = c;
                board[b][a] = c;
            }
        }

        for(int k=1; k<N+1; k++){
            for(int i=1; i<board.length; i++){
                if(board[i][k] == Integer.MAX_VALUE) continue;
                for(int j=1; j<board[0].length; j++){
                    if(board[k][j] == Integer.MAX_VALUE) continue;
                    if(board[i][j] > board[i][k]+board[k][j]){
                        board[i][j] = board[i][k]+board[k][j];
                    }
                }
            }   
        }
        
        for(int i=1; i<board.length; i++){
            if(board[1][i]<=K){
                answer++;
            }
        }
        
        return answer;
    }
}