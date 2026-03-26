import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] board, dp;
	static boolean[][] visited, inStack;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean cycle = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");

		N = Integer.parseInt(temp[0]);
		M = Integer.parseInt(temp[1]);

		board = new int[N][M];
		dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			temp = br.readLine().trim().split("");
			for (int j = 0; j < M; j++) {
				if (temp[j].equals("H")) {
					board[i][j] = -1;
					continue;
				}
				board[i][j] = Integer.parseInt(temp[j]);
			}
		}

		visited = new boolean[N][M];
		inStack = new boolean[N][M];

		System.out.print(dfs(0, 0));

	}

	private static int dfs(int r, int c) {
		if (cycle)
			return -1;
		if (visited[r][c])
			return dp[r][c];

		visited[r][c] = true;
		inStack[r][c] = true;
		dp[r][c] = 1;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i] * board[r][c];
			int nc = c + dc[i] * board[r][c];

			if (nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] == -1)
				continue;
			if (inStack[nr][nc]) {
				cycle = true;
				return -1;
			}

			int next = dfs(nr, nc);
			if (cycle)
				return -1;
			dp[r][c] = Math.max(dp[r][c], next + 1);
		}
		inStack[r][c] = false;
		return dp[r][c];
	}

}