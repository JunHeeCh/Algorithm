class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        String target = board[h][w];
        
        int[] dr = new int[]{-1,1,0,0};
        int[] dc = new int[]{0,0,-1,1};
        
        for(int i=0; i<4; i++){
            int nr = h+dr[i];
            int nc = w+dc[i];
            
            if(nr < 0 || nc < 0 || nr >= board.length || nc >= board[0].length) continue;
            if(board[nr][nc].equals(target)){
                answer++;
            }
        }
        return answer;
    }
}