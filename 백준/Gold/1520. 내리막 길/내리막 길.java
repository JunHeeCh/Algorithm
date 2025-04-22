import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().trim().split(" ");
		int M = Integer.parseInt(nm[0]);
		int N = Integer.parseInt(nm[1]);

		int[][] board = new int[M][N];

		for (int i = 0; i < board.length; i++) {
			String[] temp = br.readLine().trim().split(" ");
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = Integer.parseInt(temp[j]);
			}
		}
		// 입력 완료

		boolean[][] visited = new boolean[M][N];
		int[][] res = new int[M][N];
		res[M - 1][N - 1] = 1;

		PriorityQueue<point> queue = new PriorityQueue<>();
		queue.add(new point(M - 1, N - 1, board[M - 1][N - 1]));

		while (!queue.isEmpty()) {
			point now = queue.poll();
			int r = now.r;
			int c = now.c;

			for (int i = 0; i < dr.length; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= 0 && nr < M && nc >= 0 && nc < N) {
					if (now.val < board[nr][nc]) {
						// 갈 수 있는 경로
						res[nr][nc] += res[r][c];
						if(!visited[nr][nc]) {
							queue.add(new point(nr, nc, board[nr][nc]));
							visited[nr][nc] = true;
						}
					}
				}

			}


		}

		System.out.println(res[0][0]);

	}

	

	static class point implements Comparable<point> {
		int r, c;
		int val;

		public point(int r, int c, int val) {
			this.r = r;
			this.c = c;
			this.val = val;
		}

		@Override
		public int compareTo(point o) {
			return Integer.compare(this.val, o.val);
		}

	}

}
