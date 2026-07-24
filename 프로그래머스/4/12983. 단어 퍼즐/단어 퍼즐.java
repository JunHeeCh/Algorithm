import java.util.*;

class Solution {
    public int solution(String[] strs, String t) {
        int n = t.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue; // 이 위치엔 도달 불가능하니 스킵

            for (String s : strs) {
                int len = s.length();
                if (i + len <= n && t.startsWith(s, i)) {
                    if (dp[i] + 1 < dp[i + len]) {
                        dp[i + len] = dp[i] + 1;
                    }
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}