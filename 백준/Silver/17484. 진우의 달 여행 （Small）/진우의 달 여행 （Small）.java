import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);

		int[][] origin = new int[N][M];
		for (int i = 0; i < origin.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < origin[0].length; j++) {
				origin[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][][] board = new int[N][M][3];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				for (int j2 = 0; j2 < board[0][0].length; j2++) {
					board[i][j][j2] = 1000;
				}
			}
		}

		for (int i = 0; i < board[0].length; i++) {
			for (int j = 0; j < board[0][0].length; j++) {
				board[0][i][j] = origin[0][i];
			}
		}

		for (int i = 1; i < origin.length; i++) {
			for (int j = 0; j < origin[0].length; j++) {
				for (int k = 0; k < board[0][0].length; k++) {
					if (board[i - 1][j][k] != 1000) {
						int n1 = (k + 1) % 3 -1;
						int n2 = (k + 2) % 3 -1;
						
						if(j+n1 >= 0&& j+n1 < M) {
							board[i][j+n1][n1+1] = Math.min(board[i][j+n1][n1+1], board[i-1][j][k]+origin[i][j+n1]);
						}
						if(j+n2 >= 0 && j+n2 < M) {
							board[i][j+n2][n2+1] = Math.min(board[i][j+n2][n2+1], board[i-1][j][k]+origin[i][j+n2]);
						}
					}
				}
			}
		}
		
		int res = 1000;
		
		for (int i = 0; i < board[0][0].length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				res = Math.min(res, board[N-1][j][i]);
			}
		}
		System.out.println(res);
	}
}
