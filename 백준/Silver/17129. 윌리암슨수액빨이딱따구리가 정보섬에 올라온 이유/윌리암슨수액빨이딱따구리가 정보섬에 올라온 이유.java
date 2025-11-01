import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] board = new int[n][m];

		Queue<int[]> queue = new LinkedList();
		boolean[][] visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().trim().split("");
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(temp[j]);
				if (board[i][j] == 2) {
					queue.add(new int[] { i, j, 0 });
				} else if (board[i][j] == 1) {
					visited[i][j] = true;
				}
			}
		}

		int[] dr = new int[] { -1, 1, 0, 0 };
		int[] dc = new int[] { 0, 0, -1, 1 };

		boolean flag = false;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			if (board[now[0]][now[1]] > 2) {
				System.out.println("TAK");
				System.out.println(now[2]);
				flag = true;
				break;
			}

			for (int i = 0; i < dr.length; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];

				if (nr < 0 || nr >= n || nc < 0 || nc >= m || visited[nr][nc]) {
					continue;
				}
				visited[nr][nc] = true;
				queue.add(new int[] { nr, nc, now[2] + 1 });
			}
		}

		if (!flag) {
			System.out.println("NIE");
		}

	}

}
