import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		int[][] board = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().trim().split(" ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		if(check(board)) {
			for (int k = 0; k < board.length; k++) {
				for (int i = 0; i < board.length; i++) {
					for (int j = 0; j < board.length; j++) {

						if (i != j && i != k && j != k && board[i][k] + board[k][j] == board[i][j]) {
							board[i][j] = 3000;
						}

					}
				}
			}

			int res = 0;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					if (board[i][j] != 3000) {
						res += board[i][j];
					}
				}
			}

			System.out.println(res / 2);
		}else {
			System.out.println(-1);
		}
		
		

		

	}

	private static boolean check(int[][] board) {
		for (int k = 0; k < board.length; k++) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {

					if (board[i][k] + board[k][j] < board[i][j]) {
						return false;
					}

				}
			}
		}
		return true;
	}
}
