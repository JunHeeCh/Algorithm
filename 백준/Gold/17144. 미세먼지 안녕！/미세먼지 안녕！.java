import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int[] dr = new int[] { 0, 0, -1, 1 };
	static int[] dc = new int[] { -1, 1, 0, 0 };

	static int[] clockR = new int[] { 0, 1, 0, -1 };
	static int[] clockC = new int[] { 1, 0, -1, 0 };

	static int[] clockwiseR = new int[] { 0, -1, 0, 1 };
	static int[] clockwiseC = new int[] { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int R = Integer.parseInt(temp[0]);
		int C = Integer.parseInt(temp[1]);
		int T = Integer.parseInt(temp[2]);

		int[][] board = new int[R][C];

		int purifier = 0;

		for (int i = 0; i < board.length; i++) {
			temp = br.readLine().trim().split(" ");
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = Integer.parseInt(temp[j]);
				if (board[i][j] == -1) {
					purifier = i;
				}
			}
		}

		for (int i = 0; i < T; i++) {
			spread(board);
			air(board, purifier);
		}

		int res = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] > 0) {
					res += board[i][j];
				}
			}
		}

		System.out.println(res);

	}

	private static void air(int[][] board, int purifier) {
		int[] now = new int[] { purifier - 1, 0 }; // 반시계
		int priv = 0;
		int curr = 0;

		for (int i = 0; i < clockwiseR.length; i++) {
			while (true) {
				int nr = now[0] + clockwiseR[i];
				int nc = now[1] + clockwiseC[i];

				if (nr >= board.length || nc >= board[0].length || nr < 0 || nc < 0 || board[nr][nc] == -1) {
					break;
				}
				curr = board[nr][nc];
				board[nr][nc] = priv;
				priv = curr;

				now = new int[] { nr, nc };

			}
		}
		////////////////////////////////////
		now = new int[] { purifier, 0 }; // 시계
		priv = 0;
		curr = 0;
		for (int i = 0; i < clockR.length; i++) {
			while (true) {
				int nr = now[0] + clockR[i];
				int nc = now[1] + clockC[i];

				if (nr >= board.length || nc >= board[0].length || nr < 0 || nc < 0 || board[nr][nc] == -1) {
					break;
				}
				curr = board[nr][nc];
				board[nr][nc] = priv;
				priv = curr;

				now = new int[] { nr, nc };
			}
		}
	}

	private static void spread(int[][] board) {
		Queue<int[]> queue = new LinkedList();

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] > 0) {
					queue.add(new int[] { i, j, board[i][j] });
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			int add = now[2] / 5;
			int count = 0;

			for (int i = 0; i < dr.length; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];

				if (nr >= board.length || nc >= board[0].length || nr < 0 || nc < 0 || board[nr][nc] == -1) {
					continue;
				}

				board[nr][nc] += add;
				count++;
			}

			board[now[0]][now[1]] -= add * count;

		} // while

	}
}