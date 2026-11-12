def solution(n):
    
    if n%2!=0:
        return 0
    
    dp = [1,0,3,0,11]
    
    for i in range(6,n+1,2):
        x = dp[i-2]*3 
        for j in range(i-4, -1, -2):
            x += dp[j]*2
        dp.append(0)
        x %= 1000000007
        dp.append(x)
    return dp[n]