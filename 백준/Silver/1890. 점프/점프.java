import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bReader.readLine().trim());

		int[][] board = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] tempStrings = bReader.readLine().trim().split(" ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(tempStrings[j]);
			}
		}
		// 입력 완료

		long[][] cnt = new long[N][N];
		cnt[0][0] = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				check(N, board, cnt, i, j);
			}
		}
		
		System.out.println(cnt[N-1][N-1]);

	}

	private static void check(int N, int[][] board, long[][] cnt, int r, int c) {

		int[] dr = { -1, 0 };
		int[] dc = { 0, -1 }; // 위쪽, 왼쪽
		//위쪽 탐색 시
		for (int j = 1; j <= r; j++) {	//power
			if(r-j>=0 && board[r-j][c] == j) {
				cnt[r][c] += cnt[r-j][c]; 
			}
		}
		//왼쪽 탐색 시
		for (int j = 1; j <= c; j++) {	//power
			if(c-j>=0 && board[r][c-j] == j) {
				cnt[r][c] += cnt[r][c-j]; 
			}
		}

	}
}
