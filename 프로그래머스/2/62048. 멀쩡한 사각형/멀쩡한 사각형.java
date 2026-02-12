class Solution {
    public long solution(int w, int h) {
        long W = w, H = h;
        long answer = W * H;

        for (long i = 0; i < W; i++) {
            long a = (H * i) / W;                 // floor(H*i/W)
            long b = (H * (i + 1) + W - 1) / W;   // ceil(H*(i+1)/W)
            answer -= (b - a);
        }
        return answer;
    }
}
