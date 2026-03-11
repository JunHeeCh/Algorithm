import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[] answer= new int[2];
        
        int[][] board = new int[m][n];
        
        for(int i=0; i<m; i++){
            Arrays.fill(board[i], Integer.MAX_VALUE);
        }
        
        for(int i=0; i<drops.length; i++){
            board[drops[i][0]][drops[i][1]] = i+1;
        }
        
        int[][] b1 = new int[m][n-w+1];
        
        for(int i=0; i<m; i++){
            Deque<int[]> dq = new ArrayDeque();
            for(int j=0; j<w; j++){
                while(!dq.isEmpty() && dq.peekLast()[0]>=board[i][j]){
                    dq.pollLast();
                }
                dq.addLast(new int[]{board[i][j], j});
                
            }
            b1[i][0] = dq.peekFirst()[0];
            for(int j=1; j<=n-w; j++){
                while(!dq.isEmpty() && dq.peekLast()[0]>=board[i][j+w-1]){
                    dq.pollLast();
                }
                dq.addLast(new int[]{board[i][j+w-1], j+w-1});
                while(!dq.isEmpty() && dq.peekFirst()[1]<j){
                    dq.pollFirst();
                }
                b1[i][j] = dq.peekFirst()[0];
            }
        }
        
        int[][] b2 = new int[m-h+1][n-w+1];
        for(int j=0; j<=n-w; j++){
    Deque<int[]> dq = new ArrayDeque<>();

    for(int i=0; i<h; i++){
        while(!dq.isEmpty() && dq.peekLast()[0] >= b1[i][j]){
            dq.pollLast();
        }
        dq.addLast(new int[]{b1[i][j], i});
    }

    b2[0][j] = dq.peekFirst()[0];

    for(int i=1; i<=m-h; i++){
        while(!dq.isEmpty() && dq.peekLast()[0] >= b1[i + h - 1][j]){
            dq.pollLast();
        }
        dq.addLast(new int[]{b1[i + h - 1][j], i + h - 1});

        while(!dq.isEmpty() && dq.peekFirst()[1] < i){
            dq.pollFirst();
        }

        b2[i][j] = dq.peekFirst()[0];
    }
}
        
        int max = -1;
        
        for(int i=0; i<b2.length; i++){
            for(int j=0; j<b2[0].length; j++){
                if(b2[i][j] == Integer.MAX_VALUE){
                    return new int[]{i,j};
                }
                if(max < b2[i][j]){
                    max = b2[i][j]; 
                    answer = new int[]{i,j};
                }
            }
        }
        return answer;
    }
}