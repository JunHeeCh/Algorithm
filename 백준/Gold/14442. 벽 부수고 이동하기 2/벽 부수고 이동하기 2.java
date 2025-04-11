import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static int[][] board;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, M, K, res = -1;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().trim().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
		K = Integer.parseInt(nm[2]); // 부수어도 되는 벽 개수

		board = new int[N][M];

		for (int i = 0; i < board.length; i++) {
			String temp = br.readLine().trim();
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = temp.charAt(j) - '0';
			}
		}

		// 입력 완료

		bfs();

		System.out.println(res);

	}

	// 0,0에서 N-1,M-1로 이동
	private static void bfs() {
		if (N == 1 && M == 1) {
			res = 1;
			return;
		}

		boolean[][][] visited = new boolean[K + 1][N][M];

		ArrayDeque<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { 0, 0, 0, 1 }); // r,c,부순 벽 수, 이동 횟수
		visited[0][0][0] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			if (now[0] == N - 1 && now[1] == M - 1) {
				res = now[3];
				return;
			}

			for (int i = 0; i < dr.length; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				int count = now[2];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;

				if (count == K && board[nr][nc] == 1)
					continue;

				if (board[nr][nc] == 1 && count < K && !visited[count + 1][nr][nc]) {
					visited[count + 1][nr][nc] = true;
					queue.add(new int[] { nr, nc, count + 1, now[3] + 1 });
				} else if (board[nr][nc] == 0 && !visited[count][nr][nc]) {
					visited[count][nr][nc] = true;
					queue.add(new int[] { nr, nc, count, now[3] + 1 });
				}
			}

		} // while

	}
}
