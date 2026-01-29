class Solution {
    static int zero;
    static int one;
    
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        
        int n = arr.length;         
        zero = 0;
        one = 0;
        
        find(arr, 0,0,n);
        answer[0] = zero;
        answer[1] = one;
        
        return answer;
    }
    
    public void find(int[][] board, int x, int y, int len){
        boolean flag = true;
        int st = board[x][y];
        
        for(int i=x; i<x+len; i++){
            for(int j=y; j<y+len; j++){
                if(board[i][j] != st){
                    // 사분할
                    flag = false;
                    find(board, x,y,len/2);
                    find(board, x+len/2,y,len/2);
                    find(board, x,y+len/2,len/2);
                    find(board, x+len/2,y+len/2,len/2);
                    return;
                }
            }
            if(!flag) break;
        }
        
        if(flag){
            if(st==0) zero++;
            else one++;
        }
    }
}