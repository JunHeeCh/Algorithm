class Solution {
    public int solution(int[][] beginning, int[][] target) {
        int answer = Integer.MAX_VALUE;
        
        int n = target.length;
        int m = target[0].length;
        
        int[][] board = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(beginning[i][j]!=target[i][j]){
                    board[i][j] = 1;
                }
            }
        }
        
        for(int row=0; row<(1<<n); row++){
            int rows = Integer.bitCount(row);
            int cols = 0;
            boolean flag = true;
            
            for(int j=0; j<m; j++){
                int ones = 0;
                for(int i=0; i<n; i++){
                    int val =0;
                    if(((row>>i)&1)==1){
                        val = 1-board[i][j];
                    }else{
                        val = board[i][j];
                    }
                    ones += val;
                }
                
                if(ones==n){
                    cols++;
                }else if(ones!=0){
                    flag = false;
                    break;
                }
            }
            
            if(flag){
                answer = Math.min(answer, rows+cols);
            }
        }
        
        if(answer == Integer.MAX_VALUE){
            answer = -1;
        }
        return answer;
    }
}