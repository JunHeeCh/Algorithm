import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int wanhoA = scores[0][0];
        int wanhoB = scores[0][1];
        int wanhoSum = wanhoA + wanhoB;
        
        Arrays.sort(scores, (a,b)->{
            if(a[0]!=b[0]) return b[0]-a[0];
            return a[1]-b[1];
        });
        
        int bmax = 0;
                
        int order = 1;
        
        for(int i=0; i<scores.length; i++){
            int a = scores[i][0];
            int b = scores[i][1];
            
            if(b < bmax){
                if (a == wanhoA && b == wanhoB) return -1;
                continue;
            }
            bmax =Math.max(bmax, b);

            if(a+b>wanhoSum) order++;
        }

        return order;
    }
}

