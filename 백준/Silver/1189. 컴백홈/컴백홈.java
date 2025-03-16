
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int res;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 0, 1 };// 상하좌우
	static int[] dc = { 0, 1, -1, 0 };
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] rck = br.readLine().trim().split(" ");
		int R = Integer.parseInt(rck[0]);
		int C = Integer.parseInt(rck[1]);
		int K = Integer.parseInt(rck[2]);

		board = new int[R][C];
		for (int i = 0; i < R; i++) {
			String[] temp = br.readLine().trim().split("");
			for (int j = 0; j < C; j++) {
				if(temp[j].equals("T")) {
					board[i][j] = 10;
				}
			}
		}
		// 입력 완료
		res = 0;
		visited = new boolean[R][C];
		int startR = R - 1;
		int startC = 0;
//		int endR = 0;
//		int endC = C-1;
		findPath(K, 0, startR, startC);
		System.out.println(res);
	}

	private static void findPath(int k, int total, int r, int c) {
		if(total>k) {
			return;
		}
		
		if (r == 0 && c == board[0].length - 1) {
			if (total == k-1) {
				res++;
			}
			return;
		}

		if (!visited[r][c]) {
			visited[r][c] = true;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if(inboundary(nr,nc)) {
					findPath(k, total+1, nr, nc);
				}
			}
			visited[r][c] = false;
		}

	}

	private static boolean inboundary(int nr, int nc) {
		if(nr>=0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] != 10) {
			return true;
		}
		return false;
	}
}
