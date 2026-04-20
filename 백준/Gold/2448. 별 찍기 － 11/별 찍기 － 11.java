import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine().trim());

		char[][] board = new char[n][2 * n];
		cal(board, n, 0, n - 1);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2 * n; j++) {
				if (board[i][j] == '*') {
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}

	private static void cal(char[][] board, int n, int i, int j) {
		if (n == 3) {
			board[i][j] = '*';
			board[i + 1][j - 1] = '*';
			board[i + 1][j + 1] = '*';
			for (int a = -2; a <= 2; a++) {
				board[i + 2][j + a] = '*';
			}
			return;
		}

		cal(board, n / 2, i, j);
		cal(board, n / 2, i + n / 2, j - n / 2);
		cal(board, n / 2, i + n / 2, j + n / 2);

	}

}
