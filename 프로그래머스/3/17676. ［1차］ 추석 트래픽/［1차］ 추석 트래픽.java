import java.util.*;

class Solution {
    public int solution(String[] lines) {
        int answer = 0;
        int n = lines.length;
        long[] start = new long[n];
        long[] end = new long[n];

        for (int i = 0; i < n; i++) {
            String[] temp = lines[i].split(" ");
            long processMs = Math.round(Double.parseDouble(temp[2].substring(0, temp[2].length() - 1)) * 1000);
            long endMs = calMs(temp[1]);
            long startMs = endMs - processMs + 1; // 1ms 단위 보정 (0.001s)
            start[i] = startMs;
            end[i] = endMs;
        }

        for (int i = 0; i < n; i++) {
            long windowStart = end[i];
            long windowEnd = windowStart + 999; // 1초 = 1000ms, 양끝 포함이므로 -1

            int count = 0;
            for (int j = 0; j < n; j++) {
                if (start[j] <= windowEnd && end[j] >= windowStart) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        return answer;
    }

    // hh:mm:ss.SSS -> 밀리초(long)
    public long calMs(String time) {
        String[] temp = time.split(":");
        long res = 0;
        res += Long.parseLong(temp[0]) * 3600_000L;
        res += Long.parseLong(temp[1]) * 60_000L;
        double sec = Double.parseDouble(temp[2]);
        res += Math.round(sec * 1000);
        return res;
    }
}