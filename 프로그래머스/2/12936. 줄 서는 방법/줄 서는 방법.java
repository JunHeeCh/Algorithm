import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];

        // factorials
        long[] fact = new long[n + 1];
        fact[0] = 1L;
        for (int i = 1; i <= n; i++) fact[i] = fact[i - 1] * i;

        // numbers list
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) nums.add(i);

        long kk = k - 1; // 0-index

        for (int pos = 0; pos < n; pos++) {
            long block = fact[n - 1 - pos];      // (n-1-pos)!
            int idx = (int)(kk / block);         // which block
            answer[pos] = nums.remove(idx);      // pick idx-th unused number
            kk %= block;
        }

        return answer;
    }
}
