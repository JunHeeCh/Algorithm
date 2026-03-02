class Solution {
    int mod = 1000000007;

    public int solution(int n) {
        if(n % 2 == 1) return 0;

        long[] dp = new long[n+1];

        if(n >= 2){
            dp[2] = 3;
        }

        for(int i = 4; i <= n; i += 2){
            dp[i] = (dp[i-2] * 3 + 2) % mod;

            for(int j = 2; j <= i-4; j += 2){
                dp[i] = (dp[i] + dp[j] * 2) % mod;
            }
        }

        return (int)dp[n];
    }
}