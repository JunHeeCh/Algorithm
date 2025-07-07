import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		int[][] board = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j) {
					board[i][j] = Integer.MAX_VALUE;
				}
			}
		}

		while (true) {
			String[] temp = br.readLine().trim().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);

			if (a == -1 && b == -1) {
				break;
			}

			board[a][b] = 1;
			board[b][a] = 1;
		}

		for (int k = 1; k < board.length; k++) {
			for (int i = 1; i < board.length; i++) {

				if (board[i][k] == Integer.MAX_VALUE) {
					continue;
				}

				for (int j = 1; j < board.length; j++) {

					if (board[k][j] == Integer.MAX_VALUE) {
						continue;
					}
					if (board[i][j] > board[i][k] + board[k][j]) {
						board[i][j] = board[i][k] + board[k][j];
					}

				}
			}
		}

		int[] score = new int[N + 1];
		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			int max = 0;
			for (int j = 1; j <= N; j++) {
				max = Math.max(max, board[i][j]);
			}
			score[i] = max;
			min = Math.min(min, score[i]);
		}

		int count = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < score.length; i++) {
			if (score[i] == min) {
				count++;
				sb.append(i + " ");
			}
		}

		System.out.println(min + " " + count);
		System.out.println(sb);

	}

}
