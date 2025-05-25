
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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {

			String[] temp = br.readLine().trim().split(" ");
			int M = Integer.parseInt(temp[0]);
			int N = Integer.parseInt(temp[1]);
			int K = Integer.parseInt(temp[2]);

			int[][] board = new int[N][M];

			for (int i = 0; i < K; i++) {
				String[] tmp = br.readLine().trim().split(" ");
				int a = Integer.parseInt(tmp[0]);
				int b = Integer.parseInt(tmp[1]);

				board[b][a] = 1;
			}

			boolean[][] visited = new boolean[N][M];
			int cnt = 0;
			
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == 1 && !visited[i][j]) {
						bfs(board, visited, i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		} // tc
	}

	private static void bfs(int[][] board, boolean[][] visited, int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { r, c });
		visited[r][c] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int i = 0; i < dr.length; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				if(nr<0 || nc < 0 || nr >= board.length || nc >= board[0].length || board[nr][nc]==0 || visited[nr][nc]) {
					continue;
				}
				queue.add(new int[] {nr,nc});
				visited[nr][nc] = true;
			}
		}

	}

}
