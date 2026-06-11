import java.util.*;

class Solution {
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    int n, m;
    int[][] maze;
    int[] redE, blueE;
    int answer = Integer.MAX_VALUE;

    public int solution(int[][] maze) {
        this.maze = maze;
        n = maze.length;
        m = maze[0].length;

        int[] redS = null, blueS = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 1) redS = new int[]{i, j};
                else if (maze[i][j] == 2) blueS = new int[]{i, j};
                else if (maze[i][j] == 3) redE = new int[]{i, j};
                else if (maze[i][j] == 4) blueE = new int[]{i, j};
            }
        }

        boolean[][] rv = new boolean[n][m];
        boolean[][] bv = new boolean[n][m];
        rv[redS[0]][redS[1]] = true;
        bv[blueS[0]][blueS[1]] = true;

        dfs(redS[0], redS[1], blueS[0], blueS[1], 0, rv, bv);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    void dfs(int rr, int rc, int br, int bc, int turn, boolean[][] rv, boolean[][] bv) {
        if (turn >= answer) return; // 가지치기

        boolean rDone = (rr == redE[0] && rc == redE[1]);
        boolean bDone = (br == blueE[0] && bc == blueE[1]);
        if (rDone && bDone) { answer = Math.min(answer, turn); return; }

        // 도착한 수레는 제자리(이동 안 함), 아직이면 반드시 한 칸 이동
        List<int[]> redMoves = buildMoves(rr, rc, rDone, rv);
        List<int[]> blueMoves = buildMoves(br, bc, bDone, bv);

        for (int[] rm : redMoves) {
            for (int[] bm : blueMoves) {
                // 같은 칸 금지
                if (rm[0] == bm[0] && rm[1] == bm[1]) continue;
                // 자리 맞바꿈(swap) 금지
                if (rm[0] == br && rm[1] == bc && bm[0] == rr && bm[1] == rc) continue;

                boolean redMoved = !(rm[0] == rr && rm[1] == rc);
                boolean blueMoved = !(bm[0] == br && bm[1] == bc);

                if (redMoved) rv[rm[0]][rm[1]] = true;
                if (blueMoved) bv[bm[0]][bm[1]] = true;

                dfs(rm[0], rm[1], bm[0], bm[1], turn + 1, rv, bv);

                if (redMoved) rv[rm[0]][rm[1]] = false;   // 백트래킹
                if (blueMoved) bv[bm[0]][bm[1]] = false;
            }
        }
    }

    List<int[]> buildMoves(int r, int c, boolean done, boolean[][] visited) {
        List<int[]> moves = new ArrayList<>();
        if (done) {            // 도착했으면 그 자리에 고정
            moves.add(new int[]{r, c});
            return moves;
        }
        for (int i = 0; i < 4; i++) {   // 아직이면 4방향으로 반드시 이동
            int x = r + dr[i], y = c + dc[i];
            if (x < 0 || x >= n || y < 0 || y >= m) continue;
            if (maze[x][y] == 5) continue;       // 벽
            if (visited[x][y]) continue;          // 이미 지난 칸 금지
            moves.add(new int[]{x, y});
        }
        return moves;
    }
}