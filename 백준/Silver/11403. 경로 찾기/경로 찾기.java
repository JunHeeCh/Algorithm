import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().trim().split(" ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(temp[j]);
				if (board[i][j] == 0) {
					board[i][j] = INF;
				}
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (board[i][k] == INF)
					continue;
				for (int j = 0; j < N; j++) {
					if (board[k][j] == INF)
						continue;

					if (board[i][j] > board[i][k] + board[k][j]) {
						board[i][j] = board[i][k] + board[k][j];
					}
				}
			}
		}
		
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j]==INF) {
					System.out.print(0+" ");
				}else {
					System.out.print(1+" ");
				}
			}
			System.out.println();
		}

	}
}
