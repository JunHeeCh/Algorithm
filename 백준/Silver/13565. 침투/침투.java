import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static boolean victory;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N,M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().trim().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);

		int[][] board = new int[N][M];
		for (int i = 0; i < board.length; i++) {
			String[] temp = br.readLine().trim().split("");
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = Integer.parseInt(temp[j]);
			}
		}
		// 입력 완료
		visited = new boolean[N][M];
		
		for (int i = 0; i < board[0].length; i++) {
			if (board[0][i] == 0 && !visited[0][i] && !victory) {
				visited[0][i] = true;
				dfs(board, 0, i);
				visited[0][i] = false;
			}
		}

		if (victory) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}

	}

	private static void dfs(int[][] board, int i, int j) {
		if(victory) return;
		
		if(i == N-1) {
			if(board[i][j] == 0) {
				victory = true;
			}
			return;
		}
		
		
		
		for (int k = 0; k < dr.length; k++) {
			int nr = i + dr[k];
			int nc = j + dc[k];
			if(inBoundary(nr,nc) && board[nr][nc]==0 && !visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(board, nr, nc);
				
			}
		}

	}

	private static boolean inBoundary(int nr, int nc) {
		if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
			return true;
		}
		return false;
	}
}
