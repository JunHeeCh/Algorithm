import java.util.*;

class Solution {
    public int solution(int m, int n, String[] words) {
        int answer = 0;
        int[][] board = new int[m][n];
        for(int i=0; i<words.length; i++){
            char[] temp = words[i].toCharArray();
            for(int j=0; j<temp.length; j++){
                board[i][j] = temp[j]-'A';
                // if(temp[j]=='R'){
                //     board[i][j] = 1;
                // }else if(temp[j]=='A'){
                //     board[i][j] = 2;
                // }else if(temp[j]=='F'){
                //     board[i][j] = 3;
                // }else if(temp[j]=='N'){
                //     board[i][j] = 4;
                // }else if(temp[j]=='T'){
                //     board[i][j] = 5;
                // }else if(temp[j]=='J'){
                //     board[i][j] = 6;
                // }else if(temp[j]=='C'){
                //     board[i][j] = 7;
                // }
            }
        }
        
        int count = 1;
        while(count > 0){
            count = vanish(board);
            answer += count;
            push(board);
        }
        
        return answer;
    }
    
    public void push(int[][] board){
        for(int i=0; i<board[0].length; i++){
            Stack<Integer> stack = new Stack();
            for(int j=0; j<board.length; j++){
                if(board[j][i] != -1){
                    stack.push(board[j][i]);
                }
            }
            
            for(int j=board.length-1; j>=0; j--){
                if(!stack.isEmpty()){
                    board[j][i] = stack.pop();
                }else{
                    board[j][i] = -1;
                }
            }
        }
    }
    
    public int vanish(int[][] board){
        int cnt = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for(int i=0; i<board.length-1; i++){
            for(int j=0; j<board[i].length-1; j++){
                int num = board[i][j];
                if(board[i][j] == -1) continue;
                if(board[i+1][j]==num &&board[i][j+1]==num &&board[i+1][j+1]==num){
                    visited[i][j] = true;
                    visited[i+1][j] = true;
                    visited[i][j+1] = true;
                    visited[i+1][j+1] = true;
                }
            }
        }
        
        for(int i=0; i<visited.length; i++){
            for(int j=0; j<visited[i].length; j++){
                if(visited[i][j]){
                    cnt++;
                    board[i][j] = -1;
                }
            }
        }
        
        return cnt;
            
    }
}