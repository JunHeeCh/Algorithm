import java.util.*;
import java.io.*;

public class Main {
	static int[] Qdr = new int[] { -1, 1, 0, 0, -1, 1, 1, -1 }; // 상하좌우, 우상, 우하, 좌하, 좌상
	static int[] Qdc = new int[] { 0, 0, -1, 1, 1, 1, -1, -1 };

	static int[] Kdr = new int[] { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] Kdc = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] board = new int[n][m];
		boolean[][] visited = new boolean[n][m];

		st = new StringTokenizer(br.readLine().trim());
		int k = Integer.parseInt(st.nextToken());
		chess[] Queen = new chess[k];

		for (int i = 0; i < k; i++) {
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			Queen[i] = new chess(r, c);
			board[r][c] = 1;
		}

		st = new StringTokenizer(br.readLine().trim());
		k = Integer.parseInt(st.nextToken());
		chess[] Knight = new chess[k];

		for (int i = 0; i < k; i++) {
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			Knight[i] = new chess(r, c);
			board[r][c] = 2;
		}

		st = new StringTokenizer(br.readLine().trim());
		k = Integer.parseInt(st.nextToken());
		chess[] Pawn = new chess[k];

		for (int i = 0; i < k; i++) {
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			Pawn[i] = new chess(r, c);
			board[r][c] = 3;
			visited[r][c] = true;
		}

		int max = Math.max(n, m);
		for (chess chess : Queen) {
			moveQ(chess, board, visited, max);
		}

		for (chess chess : Knight) {
			moveN(chess, board, visited);
		}

		int res = 0;
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[0].length; j++) {
				if(!visited[i][j]) {
					res++;
				}
			}
		}
		
		System.out.println(res);
	}

	private static void moveN(chess chess, int[][] board, boolean[][] visited) {
		int sr = chess.r;
		int sc = chess.c;
		visited[sr][sc] = true;

		for (int i = 0; i < Kdr.length; i++) {
			int nr = sr + Kdr[i];
			int nc = sc + Kdc[i];

			if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length) {
				continue;
			}

			visited[nr][nc] = true;

		}
	}

	private static void moveQ(chess chess, int[][] board, boolean[][] visited, int max) {
		int sr = chess.r;
		int sc = chess.c;
		visited[sr][sc] = true;

		for (int i = 0; i < Qdr.length; i++) {
			for (int j = 1; j <= max; j++) {
				int nr = sr + Qdr[i] * j;
				int nc = sc + Qdc[i] * j;

				if (nr < 0 || nr >= board.length || nc < 0 || nc >= board[0].length || board[nr][nc] > 0) {
					break;
				}

				visited[nr][nc] = true;
			}
		}
	}

}

class chess {
	int r, c;

	public chess(int r, int c) {
		this.r = r;
		this.c = c;
	}
}