import java.util.*;

class Solution {
    int count = 0;
    
    public int solution(int n) {

        int[][] ans = new int[n][2];
        
        find(ans, 0, n);
        return count;
    }
    
    public void find(int[][] ans, int r, int n){
        if(r==n){
            count++;
            return;
        }
        
        for(int i=0; i<n; i++){
            // r,i 위치에 둘 수 있는지를 체크해야 함 
            // 가능하면 다음으로 진행 ㄱㄱ 
            if(check(ans, r, i)){
                ans[r][0] = r;
                ans[r][1] = i;
                find(ans, r+1, n);
            }
        }
    }
    
    public boolean check(int[][] ans, int r, int c){
        for(int i=0; i<r; i++){
            int pr = ans[i][0];
            int pc = ans[i][1];
            
            if(pr==r || pc==c) return false;
            if(Math.abs(pr-r)==Math.abs(pc-c)) return false;
        }
      
        return true;
    }
}