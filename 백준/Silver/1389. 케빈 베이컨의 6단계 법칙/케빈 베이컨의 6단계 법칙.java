import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().trim().split(" ");
		
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);
		
		int[][] board = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			String[] temp = br.readLine().trim().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			
			board[a][b] = 1;
			board[b][a] = 1;
			
		}
		
		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board.length; j++) {
				if(board[i][j]==0) {
					board[i][j]=INF;
				}
			}
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if (board[i][k] == INF)
					continue;
				for (int j = 1; j <= N; j++) {
					if (board[k][j] == INF)
						continue;

					if (board[i][j] > board[i][k] + board[k][j]) {
						board[i][j] = board[i][k] + board[k][j];
					}
				}
			}
		}
		
		int min = 98765421;
		int idx = 0;
		for (int i = 1; i < board.length; i++) {
			int total = 0;
			for (int j = 1; j < board.length; j++) {
				total += board[i][j];
			}
			if(min > total) {
				min = total;
				idx = i;
			}
		}
		
		System.out.println(idx);

	}
}
