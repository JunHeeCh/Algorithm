class Solution {
    public int solution(int n, long l, long r) {
        return (int) count(n, l, r);
    }

    private long count(int n, long l, long r) {
        if (l > r) return 0;

        if (n == 0) {
            return 1; // n=0이고 l<=r 이면 무조건 [1,1] 구간이므로 1
        }

        long blockLen = pow5(n - 1); // 블록 하나의 길이

        long total = 0;
        for (int block = 0; block < 5; block++) {
            if (block == 2) continue; 

            long start = block * blockLen + 1;
            long end = (block + 1) * blockLen;

            long segL = Math.max(l, start);
            long segR = Math.min(r, end);

            if (segL <= segR) {
                total += count(n - 1, segL - start + 1, segR - start + 1);
            }
        }
        return total;
    }

    private long pow5(int n) {
        long result = 1;
        for (int i = 0; i < n; i++) result *= 5;
        return result;
    }
}