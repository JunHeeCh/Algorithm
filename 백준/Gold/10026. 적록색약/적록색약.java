
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		int[][] board = new int[N][N];

		for (int i = 0; i < board.length; i++) {
			char[] temp = br.readLine().trim().toCharArray();
			for (int j = 0; j < board.length; j++) {
				if (temp[j] == 'R') {
					board[i][j] = 1;
				} else if (temp[j] == 'G') {
					board[i][j] = 11;
				} else if (temp[j] == 'B') {
					board[i][j] = 2;
				}
			}
		}
		// 입력 완료

		boolean[][] people = new boolean[N][N];
		int p = 0;
		boolean[][] redgreen = new boolean[N][N];
		int rg = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (!people[i][j]) {
					bfs(board, people, i, j);
					p++;
				}
				if (!redgreen[i][j]) {
					bfsrg(board, redgreen, i, j);
					rg++;
				}
			}
		}

		System.out.println(p + " " + rg);

	}

	private static void bfsrg(int[][] board, boolean[][] redgreen, int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		
		redgreen[i][j] = true;
		int check = board[i][j]%10;
		
		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int k = 0; k < dr.length; k++) {
				int nr = now[0] + dr[k];
				int nc = now[1] + dc[k];

				if (nr >= 0 && nr < board.length && nc >= 0 && nc < board.length && board[nr][nc]%10 == check
						&& !redgreen[nr][nc]) {
					redgreen[nr][nc] = true;
					queue.add(new int[] { nr, nc });
				}

			}
		}
		return;
	}

	private static void bfs(int[][] board, boolean[][] people, int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		
		people[i][j] = true;
		int check = board[i][j];

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int k = 0; k < dr.length; k++) {
				int nr = now[0] + dr[k];
				int nc = now[1] + dc[k];

				if (nr >= 0 && nr < board.length && nc >= 0 && nc < board.length && board[nr][nc] == check
						&& !people[nr][nc]) {
					people[nr][nc] = true;
					queue.add(new int[] { nr, nc });
				}

			}
		}

		return;
	}
}
