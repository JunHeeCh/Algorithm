import java.util.*;

class Solution {
    public long solution(int r11, int r22) {

        long r1 = r11;
        long r2 = r22;

        long answer = 0;

        long xOuter = r2;  // 바깥 원 x 최대
        long xInner = r1;  // 안쪽 원 x 최대 (내부용)

        for (long y = 0; y <= r2; y++) {

            // 바깥 원: xOuter^2 + y^2 <= r2^2
            while (xOuter * xOuter + y * y > r2 * r2) {
                xOuter--;
            }

            long minX = 0;

            if (y < r1) {
                // 안쪽 원: x^2 + y^2 >= r1^2
                while (xInner > 0 && xInner * xInner + y * y >= r1 * r1) {
                    xInner--;
                }
                minX = xInner + 1;
            }

            if (xOuter >= minX)
                answer += (xOuter - minX + 1);
        }

        // y축 제거 후 ×4 구조라면 보정 유지
        answer -= (r2 - r1 + 1);

        return answer * 4;
    }
}