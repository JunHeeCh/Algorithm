
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		int M = Integer.parseInt(br.readLine().trim());

		int[][] board = new int[N+1][N+1];

		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board.length; j++) {
				if (i != j)
					board[i][j] = INF;
			}
		}

		for (int i = 0; i < M; i++) {
			String[] temp = br.readLine().trim().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			int c = Integer.parseInt(temp[2]);

			board[a][b] = Math.min(board[a][b], c);
		}
		
		for (int k = 1; k < board.length; k++) {
			for (int i = 1; i < board.length; i++) {
				if(board[i][k] == INF) continue;
				
				for (int j = 1; j < board.length; j++) {
					if(board[k][j] == INF) continue;
					
					board[i][j] = Math.min(board[i][j], board[i][k]+board[k][j]);
				}
			}
		}
		
		for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board.length; j++) {
				if(board[i][j]==INF) board[i][j]=0;
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}

	}
}
