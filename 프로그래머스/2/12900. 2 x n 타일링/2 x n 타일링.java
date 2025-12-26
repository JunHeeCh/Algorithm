import java.util.*;

class Solution {
    int num = 1000000007;
    public int solution(int n) {
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        if(n>=2) dp[2] = 2;
        
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1]+dp[i-2])%num;
        }

        return dp[n];
    }
    

}