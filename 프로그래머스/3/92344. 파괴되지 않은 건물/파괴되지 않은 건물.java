class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int[][] diff = new int[board.length+1][board[0].length+1];
        
        for(int i=0; i<skill.length; i++){
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int power = skill[i][5];
            
            if(skill[i][0]==1){ // 공격
                power *= -1;
            }
            
            diff[r1][c1] += power;
            diff[r1][c2+1] -= power;
            diff[r2+1][c1] -= power;
            diff[r2+1][c2+1] += power;
        }
        
        for(int i=0; i<diff.length; i++){
            for(int j=1; j<diff[0].length; j++){
                diff[i][j] += diff[i][j-1];
            }
        }
        
        for(int i=1; i<diff.length; i++){
            for(int j=0; j<diff[0].length; j++){
                diff[i][j] += diff[i-1][j];
            }
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]+diff[i][j]>0) answer++;
            }
        }
        return answer;
    }
}