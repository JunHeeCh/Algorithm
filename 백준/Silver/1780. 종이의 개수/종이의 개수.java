import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int cnt_minus = 0;
	static int cnt_plus = 0;
	static int cnt_zero = 0;
	static int fin;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		int[][] board = new int[N][N];
		boolean[][] visited = new boolean[N][N];

		for (int i = 0; i < board.length; i++) {
			String[] temp = br.readLine().trim().split(" ");
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = Integer.parseInt(temp[j]);
			}
		}
		// 입력 완
		int len = N;
		fin = N*N;

		while (fin > 0) {
			check(board, visited, len);
			len /= 3;
		}

		System.out.println(cnt_minus);
		System.out.println(cnt_zero);
		System.out.println(cnt_plus);

	}

	private static void check(int[][] board, boolean[][] visited, int len) {

		for (int i = 0; i < board.length; i += len) {
			for (int j = 0; j < board.length; j += len) {
				// board[i][j]는 스타팅 포인트
				if(visited[i][j]) continue;
				
				boolean complete = true;
				for (int r = i; r < i + len; r++) {
					for (int c = j; c < j + len; c++) {
						// board[r][c] 가 모두 같은 숫자인지 확인
						if (board[r][c] != board[i][j]) {
							complete = false;
							break;
						}
					}
					if(!complete) {
						break;
					}
				}
				
				if(complete) {
					//색종이가 완성되는 경우
					for (int r = i; r < i + len; r++) {
						for (int c = j; c < j + len; c++) {
							visited[r][c] = true;
						}
					}
					if(board[i][j] == 1) {
						cnt_plus++;
					}else if (board[i][j] == 0) {
						cnt_zero++;
					}else {
						cnt_minus++;
					}
					fin -= len*len;
				}
				
			}
		}
		return;
	}

}