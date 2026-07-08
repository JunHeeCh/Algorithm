import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] idx = new int[board.length];
        Arrays.fill(idx, board.length);
        
        for(int j=0; j<board.length; j++){
            for(int i=board.length-1; i>=0; i--){
                if(board[i][j]>0){
                    idx[j] = i;
                }
            }
        }
        
        Stack<Integer> stack = new Stack();
        
        for(int i=0; i<moves.length; i++){
            int num = moves[i]-1;
            
            if(idx[num] != board.length){
                if(stack.size()>=1){
                    if(stack.peek()==board[idx[num]][num]){
                        stack.pop();
                        idx[num]++;
                        answer+=2;
                        continue;
                    }
                }
                stack.push(board[idx[num]][num]);
                idx[num]++;
            }
        }
        return answer;
    }
}