import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = { -1, 0, 1, 0 }; // 상,우,하,좌 (시계방향)
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);

		int[][] board = new int[N][M];

		temp = br.readLine().trim().split(" ");
		int r = Integer.parseInt(temp[0]);
		int c = Integer.parseInt(temp[1]);
		int d = Integer.parseInt(temp[2]);

		for (int i = 0; i < N; i++) {
			temp = br.readLine().trim().split(" ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(temp[j]);
			}
		}

		int res = 0;

		while (true) {
			if (board[r][c] == 0) {
				res++;
				board[r][c] = 2;
			}

			int nd = checkDir(board, r, c, d);
			if (nd == -1) {
				// 주변에 갈 수 있는 곳이 없당
				nd = (d + 2) % 4;
				int nr = r + dr[nd];
				int nc = c + dc[nd];
				if (board[nr][nc] == 1) {
					break;
				} else {
					r = nr;
					c = nc;
				}
			} else {
				// nd 방향으로 한칸 전진
				r += dr[nd];
				c += dc[nd];
				d = nd;
			}

		}

		System.out.println(res);
	}

	private static int checkDir(int[][] board, int r, int c, int d) {
		for (int i = 1; i <= 4; i++) {
			int nd = d - i;
			if (nd < 0) {
				nd += 4;
			}
			int nr = r + dr[nd];
			int nc = c + dc[nd];

			if (board[nr][nc] == 0) {
				return nd;
			}
		}
		return -1;
	}

}
