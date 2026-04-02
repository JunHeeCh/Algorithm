import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = new int[] { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = new int[] { 0, 1, 1, 1, 0, -1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		while (true) {

			st = new StringTokenizer(br.readLine().trim());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0)
				break;

			int[][] board = new int[h][w];
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int j = 0; j < w; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			boolean[][] visited = new boolean[h][w];
			int ans = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (!visited[i][j] && board[i][j] == 1) {
						bfs(board, visited, i, j);
						ans++;
					}
				}
			}
			System.out.println(ans);

		}

	}

	private static void bfs(int[][] board, boolean[][] visited, int r, int c) {
		visited[r][c] = true;
		Queue<int[]> queue = new LinkedList();
		queue.add(new int[] { r, c });

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int i = 0; i < dr.length; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];

				if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length || visited[nr][nc]
						|| board[nr][nc] == 0) {
					continue;
				}
				queue.add(new int[] { nr, nc });
				visited[nr][nc] = true;
			}
		}

	}

}
