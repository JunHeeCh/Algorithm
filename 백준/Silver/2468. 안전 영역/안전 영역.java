import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int safe;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] board = new int[N][N];
		int max = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = sc.nextInt();
				if (board[i][j] > max) {
					max = board[i][j];
				}
			}
		}

		safe = 1;
		for (int i = 1; i < max; i++) {
			// i는 잠기는 높이
			calc(N, board, i);
		}

		System.out.println(safe);

	}

	private static void calc(int n, int[][] board, int height) {
		boolean[][] visited = new boolean[n][n];
		int cnt = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] > height && !visited[i][j]) {
					bfs(board, visited, height, i, j);
					cnt++;
				}
			}
		}

		if (safe < cnt) {
			safe = cnt;
		}

	}

	private static void bfs(int[][] board, boolean[][] visited, int height, int R, int C) {

		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { R, C });
		visited[R][C] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int r = now[0];
			int c = now[1];

			for (int i = 0; i < dr.length; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= board.length || nc < 0 || nc >= board.length)
					continue;
				if (board[nr][nc] <= height || visited[nr][nc])
					continue;
				
				visited[nr][nc] = true;
				queue.add(new int[] { nr, nc });
			}
		} // while

	}

}
