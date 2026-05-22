import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int[][] board = new int[102][102];

        // 1단계: 모든 직사각형 2배 크기로 채우기
        for (int[] rec : rectangle) {
            int x1 = rec[0]*2, y1 = rec[1]*2, x2 = rec[2]*2, y2 = rec[3]*2;
            for (int i = x1; i <= x2; i++)
                for (int j = y1; j <= y2; j++)
                    board[i][j] = 1;
        }

        // 2단계: 각 직사각형의 내부만 지우기 (테두리는 유지)
        for (int[] rec : rectangle) {
            int x1 = rec[0]*2+1, y1 = rec[1]*2+1, x2 = rec[2]*2-1, y2 = rec[3]*2-1;
            for (int i = x1; i <= x2; i++)
                for (int j = y1; j <= y2; j++)
                    board[i][j] = 0;
        }

        // 3단계: BFS (2배 좌표계, board==1인 셀만 이동)
        boolean[][] visited = new boolean[102][102];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{characterX*2, characterY*2, 0});
        visited[characterX*2][characterY*2] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == itemX*2 && now[1] == itemY*2)
                return now[2] / 2; // 2배 거리 → 실제 거리

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];
                if (nr < 0 || nc < 0 || nr >= 102 || nc >= 102) continue;
                if (visited[nr][nc] || board[nr][nc] == 0) continue;
                queue.add(new int[]{nr, nc, now[2] + 1});
                visited[nr][nc] = true;
                
            }
        }
        return -1;
    }
}