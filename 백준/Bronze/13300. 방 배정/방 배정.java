import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int N = Integer.parseInt(st.nextToken()); 
		int K = Integer.parseInt(st.nextToken()); 
		
		int[][] board = new int[7][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int s = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			board[y][s]++;
		}
		
		int res = 0;
		
		for (int i = 1; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j]==0) continue;
				int mock = board[i][j]/K;
				int rest = board[i][j]%K;
				
				res += mock;
				if(rest !=0) {
					res += 1;
				}
			}
		}
		
		System.out.println(res);

	}

}
