class Solution {
    int[] dr = new int[]{-1,1,0,0};
    int[] dc = new int[]{0,0,-1,1};
    public int[] solution(String[] park, String[] routes) {
        
        int[][] board = new int[park.length][park[0].length()];
        int[] now = new int[2];
        
        for(int i=0; i<park.length; i++){
            for(int j=0; j<park[0].length(); j++){
                if(park[i].charAt(j)=='S'){
                    now = new int[]{i,j};
                }else if(park[i].charAt(j)=='X'){
                    board[i][j] = -1;
                }
            }
        }
        
        for(int i=0; i<routes.length; i++){
            char dir = routes[i].charAt(0);
            int n = routes[i].charAt(2)-'0';
            switch(dir){
                case 'N':
                    if(check(0, now, board, n)){
                        int nr = now[0]+dr[0]*n;
                        int nc = now[1]+dc[0]*n;
                        now = new int[]{nr,nc};
                    }
                    break;
                case 'S':
                    if(check(1, now, board, n)){
                        int nr = now[0]+dr[1]*n;
                        int nc = now[1]+dc[1]*n;
                        now = new int[]{nr,nc};
                    }
                    break;
                case 'W':
                    if(check(2, now, board, n)){
                        int nr = now[0]+dr[2]*n;
                        int nc = now[1]+dc[2]*n;
                        now = new int[]{nr,nc};
                    }
                    break;
                case 'E':
                    if(check(3, now, board, n)){
                        int nr = now[0]+dr[3]*n;
                        int nc = now[1]+dc[3]*n;
                        now = new int[]{nr,nc};
                    }
                    break;
            }
        }
        return now;
    }
    
    public boolean check(int dir, int[] now, int[][] board, int n){
        for(int i=1; i<=n; i++){
            int nr = now[0]+dr[dir]*i;
            int nc = now[1]+dc[dir]*i;
            if(nr<0||nr>=board.length||nc<0||nc>=board[0].length) 
                return false;
            if(board[nr][nc]==-1)
                return false;
        }
        return true;
    }
}