import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());
        
        boolean[][] board = new boolean[N+1][N+1];
        for (int i = 1; i < board.length; i++) {
			board[i][i] = true;
		}
        
        for (int i = 0; i < M; i++) {
			String[] temp = br.readLine().trim().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			
			board[a][b] = true;
		}
        
        for (int i = 1; i < board.length; i++) {
			for (int j = 1; j < board.length; j++) {
				for (int k = 1; k < board.length; k++) {
					if(board[j][i] && board[i][k]) {
						board[j][k] = true;
					}
				}
			}
		}
        
        for (int i = 1; i < board.length; i++) {
        	int count = 0;
			for (int j = 1; j < board.length; j++) {
				if(i != j && !board[i][j] && !board[j][i]) {
					count++;
				}
			}
			System.out.println(count);
		}
        
        
    }

	
}