import java.util.*;

class Solution {
    public int[] solution(int target) {
        
        int[][] dp = new int[target+1][4]; // 싱글, 더블, 트리플, 볼 
        
        for(int[] row : dp){
            Arrays.fill(row, Integer.MAX_VALUE/4);
        }
        dp[0] = new int[]{0,0,0,0};
        
        for(int i=1; i<=target; i++){
            // dp[i]를 저장해야 함 
            for(int j=1; j<=20 && j<=i; j++){
                int[] cand = dp[i-j].clone();
                cand[0]++;
                if(isBetter(cand, dp[i])){
                    dp[i] = cand;
                }
            }
            
            for(int j=1; j<=20 && j*2<=i; j++){
                int[] cand = dp[i-j*2].clone();
                cand[1]++;
                if(isBetter(cand, dp[i])){
                    dp[i] = cand;
                }
            }
            
            for(int j=1; j<=20 && j*3<=i; j++){
                int[] cand = dp[i-j*3].clone();
                cand[2]++;
                if(isBetter(cand, dp[i])){
                    dp[i] = cand;
                }
            }
            
            if(i>=50){
                int[] cand = dp[i-50].clone();
                cand[3]++;
                if(isBetter(cand, dp[i])){
                    dp[i] = cand;
                }
            }
        }
        
        
        
        int total = dp[target][0]+dp[target][1]+dp[target][2]+dp[target][3];
        int cnt = dp[target][0]+dp[target][3];
        int[] answer = new int[]{total, cnt};
        return answer;
    }
    
    public boolean isBetter(int[] cand, int[] curr){
        int candTotal = cand[0]+cand[1]+cand[2]+cand[3];
        int currTotal = curr[0]+curr[1]+curr[2]+curr[3];
        
        if(candTotal != currTotal){
            return candTotal<currTotal;
        }
        return (cand[0]+cand[3]) > (curr[0]+curr[3]);
    }
}