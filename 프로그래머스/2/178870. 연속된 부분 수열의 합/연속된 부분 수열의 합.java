class Solution {
    public int[] solution(int[] seq, int k) {
        int left = 0, right = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int[] answer = new int[2];

        while (right < seq.length) {
            sum += seq[right];

            while (sum > k) {
                sum -= seq[left++];
            }

            if (sum == k) {
                int len = right - left;
                if (len < minLen) {
                    minLen = len;
                    answer[0] = left;
                    answer[1] = right;
                }
            }

            right++;
        }

        return answer;
    }
}
