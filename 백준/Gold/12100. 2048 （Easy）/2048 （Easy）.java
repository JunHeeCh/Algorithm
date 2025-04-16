import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static int pprint = 0, N;
	static int[][] origin;
	static int[][] board;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine().trim());

		origin = new int[N][N];
		board = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().trim().split(" ");
			for (int j = 0; j < N; j++) {
				origin[i][j] = Integer.parseInt(temp[j]);
			}
		}

		int[] movement = new int[5];

		powerset(movement, 0);
		
		for (int i = 0; i < origin.length; i++) {
			for (int j = 0; j < origin.length; j++) {
				board[i][j] = origin[i][j];
			}
		}
		
		
		System.out.println(pprint);
	}

	private static void powerset(int[] movement, int idx) {
		if (idx == 5) {
			for (int i = 0; i < origin.length; i++) {
				for (int j = 0; j < origin.length; j++) {
					board[i][j] = origin[i][j];
				}
			}
			calc(movement);
			return;
		}

		for (int i = 1; i <= 4; i++) {
			movement[idx] = i;
			powerset(movement, idx + 1);
		}

	}

	private static void calc(int[] movement) {
		// 배열에 들어있는 순서대로 움직여서 최종 값 구하기
		// 보드만 움직이기

		for (int i = 0; i < movement.length; i++) {
			if (movement[i] == 1) {
				up();
			} else if (movement[i] == 2) {
				down();
			} else if (movement[i] == 3) {
				left();
			} else if (movement[i] == 4) {
				right();
			}
		}

		int max = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] > max) {
					max = board[i][j];
				}
			}
		}

		pprint = Math.max(pprint, max);

	}

	private static void up() {
		int idx, num;

		Stack<Integer> st = new Stack<Integer>();

		for (int c = 0; c < board.length; c++) {
			boolean dont = false;

			num = 0;
			st.clear();

			for (int r = 0; r < board.length; r++) {
				if (board[r][c] == 0)
					continue;

				if (st.size() == 0) {
					st.push(board[r][c]);
					board[r][c] = 0;
				} else {
					if(dont) {
						st.push(board[r][c]);
						board[r][c] = 0;
						dont = false;
						continue;

					}
					num = st.peek();
					if (num != board[r][c]) {
						st.push(board[r][c]);
						dont = false;
					} else {
						st.pop();
						st.push(num * 2);
						dont = true;
					}
					board[r][c] = 0;
				}

			} // col 탐색
			idx = st.size();

			while (idx > 0) {
				board[--idx][c] = st.pop();
			}

		} // row 탐색

	}

	
	private static void down() {
		int idx, num;

		Stack<Integer> st = new Stack<Integer>();

		for (int c = 0; c < N; c++) {
			boolean dont = false;

			num = 0;
			st.clear();

			for (int r = N - 1; r >= 0; r--) {
				if (board[r][c] == 0)
					continue;

				if (st.size() == 0) {
					st.push(board[r][c]);
					board[r][c] = 0;
				} else {
					if(dont) {
						st.push(board[r][c]);
						board[r][c] = 0;
						dont = false;
						continue;

					}

					num = st.peek();
					if (num != board[r][c]) {
						st.push(board[r][c]);
						dont = false;
					} else {
						st.pop();
						st.push(num * 2);
						dont = true;

					}
					board[r][c] = 0;
				}

			} // col 탐색
			idx = st.size();

			for (int i = N-idx; i < N; i++) {
				board[i][c] = st.pop();
			}
		} // row 탐색

	}

	
	private static void left() {
		int idx, num;

		Stack<Integer> st = new Stack<Integer>();

		for (int r = 0; r < board.length; r++) {
			boolean dont = false;

			num = 0;
			st.clear();

			for (int c = 0; c < board.length; c++) {
				if (board[r][c] == 0)
					continue;

				if (st.size() == 0) {
					st.push(board[r][c]);
					board[r][c] = 0;
				} else {
					if(dont) {
						st.push(board[r][c]);
						board[r][c] = 0;
						dont = false;
						continue;
					}
					num = st.peek();
					if (num != board[r][c]) {
						st.push(board[r][c]);
						dont = false;
					} else {
						st.pop();
						st.push(num * 2);
						dont = true;

					}
					board[r][c] = 0;
				}

			} // col 탐색
			idx = st.size();

			while (idx > 0) {
				board[r][--idx] = st.pop();
			}

		} // row 탐색

	}

	
	private static void right() {
		int idx, num;

		Stack<Integer> st = new Stack<Integer>();

		for (int r = 0; r < N; r++) {
			boolean dont = false;

			num = 0;
			st.clear();

			for (int c = N - 1; c >= 0; c--) {
				if (board[r][c] == 0)
					continue;

				if (st.size() == 0) {
					st.push(board[r][c]);
					board[r][c] = 0;
				} else {
					if(dont) {
						st.push(board[r][c]);
						board[r][c] = 0;
						dont = false;
						continue;

					}
					num = st.peek();
					if (num != board[r][c]) {
						st.push(board[r][c]);
						dont = false;
					} else {
						st.pop();
						st.push(num * 2);
						dont = true;
					}
					board[r][c] = 0;
				}

			} // col 탐색
			idx = st.size();

			for (int i = N-idx; i < N; i++) {
				board[r][i] = st.pop();
			}

		} // row 탐색

	}
}
