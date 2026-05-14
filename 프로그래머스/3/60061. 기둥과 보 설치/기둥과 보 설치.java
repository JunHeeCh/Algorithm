import java.util.*;

class Solution {
    
    int N;
    int[][] board;
    
    // 기존 인코딩 그대로: 1=기둥, 2=보 (비트 플래그처럼 동작)
    boolean col(int x, int y)  { return (board[x][y] & 1) != 0; }
    boolean beam(int x, int y) { return (board[x][y] & 2) != 0; }
    
    boolean canCol(int x, int y) {
        if (y == 0) return true;
        if (col(x, y-1)) return true;
        if (x > 0 && beam(x-1, y)) return true;
        if (beam(x, y)) return true;
        return false;
    }
    
    boolean canBeam(int x, int y) {
        if (col(x, y-1)) return true;
        if (x+1 <= N && col(x+1, y-1)) return true;
        if (x > 0 && x+1 <= N && beam(x-1, y) && beam(x+1, y)) return true;
        return false;
    }
    
    boolean isValid() {
        for (int i = 0; i <= N; i++)
            for (int j = 0; j <= N; j++) {
                if (col(i,j)  && !canCol(i,j))  return false;
                if (beam(i,j) && !canBeam(i,j)) return false;
            }
        return true;
    }
    
    public int[][] solution(int n, int[][] build_frame) {
        N = n;
        board = new int[n+1][n+1]; // ✅ 수정 1: n → n+1
        
        for(int i=0; i<build_frame.length; i++){
            int x    = build_frame[i][0];
            int y    = build_frame[i][1];
            int type = build_frame[i][2]; // ✅ 원본 타입 저장
            int b    = build_frame[i][3];
            
            int a = (type == 0) ? 1 : 2;
            if(b == 0) a *= -1;
            
            board[x][y] += a;
            
            // ✅ 수정 2: 유효성 검사 + 롤백
            boolean valid = (b == 1)
                ? (type == 0 ? canCol(x, y) : canBeam(x, y)) // 설치: 해당 위치만 검사
                : isValid();                                   // 삭제: 전체 재검사
            
            if(!valid) board[x][y] -= a; // 유효하지 않으면 롤백
        }
        
        List<int[]> list = new ArrayList();
        
        for(int i=0; i<=n; i++){   // ✅ 수정 3: < → <=
            for(int j=0; j<=n; j++){
                if(board[i][j]==1) list.add(new int[]{i,j,0});
                else if(board[i][j]==2) list.add(new int[]{i,j,1});
                else if(board[i][j]==3){
                    list.add(new int[]{i,j,0});
                    list.add(new int[]{i,j,1});
                }
            }
        }
        
        int[][] answer = new int[list.size()][3];
        int idx = 0;
        for(int[] arr : list) answer[idx++] = arr;
        return answer;
    }
}