class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        while (n > 0) {
            int r = n % 3;
            n /= 3;

            if (r == 0) {
                answer.append("4");
                n -= 1;
            } else if (r == 1) {
                answer.append("1");
            } else {
                answer.append("2");
            }
        }

        return answer.reverse().toString();
    }
}
