class Solution {
    static int[] dr = {0,1,0,-1};   //우 하 좌 상
    static int[] dc = {1,0,-1,0};

    
    public int[] solution(int rows, int columns, int[][] queries) {
        
        int[][] board = new int[rows][columns];
        int[][] rotate = new int[rows][columns];
        int num = 1;
        for(int i=0; i< rows; i++){
            for(int j=0; j< columns; j++){
                board[i][j] = num;
				rotate[i][j] = num;
				num++;
            }
        }
        int[] answer = new int[queries.length];
        
        for(int i=0; i< queries.length; i++){
            int sr = queries[i][0];
            int sc = queries[i][1];
            int er = queries[i][2];
            int ec = queries[i][3];
            answer[i] = move(sr,sc,er,ec,rotate);
        }

        return answer;
    }
    
    public static int move(int sr, int sc, int er, int ec, int[][] rotate){
       
        int direction = 0;
        int r = sr-1;
        int c = sc-1;
        int num = rotate[r][c];
        int temp = 0;
        int min = num;
        
        while(direction < 4){
            int nr = r+dr[direction];
            int nc = c+dc[direction];
            if(nr< sr-1 || nr >= er || nc < sc-1 || nc >= ec){
                direction++;
                continue;
            }
            temp = rotate[nr][nc]; 
            rotate[nr][nc] = num;
            num = temp;
            
            min = Math.min(min, num);
            
            r = nr;
			c = nc;

        }
        return min;
    }
}