import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        List<long[]> list = new ArrayList<>();
        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;

        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) { // 중복 쌍 제거
                long a = line[i][0], b = line[i][1], e = line[i][2];
                long c = line[j][0], d = line[j][1], f = line[j][2];

                long adbc = a*d - b*c;
                if (adbc == 0) continue;

                long bfed = b*f - e*d;
                long ecaf = e*c - a*f;
                if (bfed % adbc != 0 || ecaf % adbc != 0) continue;

                long x = bfed / adbc;
                long y = ecaf / adbc;

                list.add(new long[]{x, y});
                minX = Math.min(minX, x);  maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);  maxY = Math.max(maxY, y);
            }
        }

        int rows = (int)(maxY - minY + 1);
        int cols = (int)(maxX - minX + 1);
        char[][] board = new char[rows][cols];
        for (char[] row : board) Arrays.fill(row, '.');

        for (long[] pt : list) {
            board[(int)(maxY - pt[1])][(int)(pt[0] - minX)] = '*';
        }

        String[] answer = new String[rows];
        for (int i = 0; i < rows; i++) answer[i] = new String(board[i]);
        return answer;
    }
}