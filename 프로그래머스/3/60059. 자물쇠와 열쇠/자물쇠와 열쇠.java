class Solution {
    boolean fllag;
    public boolean solution(int[][] key, int[][] lock) {
        fllag = false;
        // 자물쇠가 키보다 크다 
        // 키를 옮겨가면서 맞는지 확인 
        // 키를 회전시키면서 맞는지 확인 
        check(lock, key);
        if(fllag) return true;
        key = rotate(key);
        check(lock, key);
        if(fllag) return true;
        key = rotate(key);
        check(lock, key);
        if(fllag) return true;
        key = rotate(key);
        check(lock, key);
        if(fllag) return true;
        
        return false;
    }
    
    public int[][] rotate(int[][] key){
        int n = key.length;
        
        int[][] copy = new int[n][n];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                copy[j][n-1-i] = key[i][j];
            }
        }
        
        return copy;
    }
    
    public void check(int[][] lock, int[][] key){
        int n = key.length;
        int m = lock.length;

        int offset = n - 1;
        int size = m + 2 * offset;

        for(int i = 0; i <= size - n; i++){
            for(int j = 0; j <= size - n; j++){

                int[][] board = new int[size][size];

                // 자물쇠 배치
                for(int r = 0; r < m; r++)
                    for(int c = 0; c < m; c++)
                        board[r + offset][c + offset] = lock[r][c];

                // 키 삽입
                for(int a = 0; a < n; a++)
                    for(int b = 0; b < n; b++)
                        board[i+a][j+b] += key[a][b];

                // 자물쇠 영역 전체 검사
                boolean flag = true;
                outer:
                for(int r = offset; r < offset + m; r++)
                    for(int c = offset; c < offset + m; c++)
                        if(board[r][c] != 1){ flag = false; break outer; }

                if(flag){ fllag = true; return; }
            }
        }
    }
}