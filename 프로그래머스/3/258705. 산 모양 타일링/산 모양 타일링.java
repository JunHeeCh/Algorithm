class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        
        int[] dp = new int[2*n+2];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2; i<dp.length; i++){
            dp[i] += dp[i-1]; // 기본 삼각형
            dp[i] += dp[i-2]; // 누워있는 마름모 
            // i가 짝수일 때
            if(i%2==0){
                int idx = i/2;
                idx--;
                if(tops[idx]==1){
                    dp[i] += dp[i-1]; // 서 있는 마름모 
                }
            }
            dp[i] = dp[i]%10007;
        }
        return dp[2*n+1];
    }
}