
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] num;
	static int N;
	static long res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		// 입력 완료

		long[][] board = new long[N-1][21];
		board[0][num[0]] = 1;
		int plus, minus;
		for (int i = 1; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i - 1][j] > 0) {
					plus = j + num[i];
					minus = j - num[i];
					if(plus>=0 && plus <= 20) {
						board[i][plus] += board[i - 1][j];
					}
					if(minus>=0 && minus <= 20) {
						board[i][minus] += board[i - 1][j];
					}
				}
			}
		}

		System.out.println(board[N-2][num[N-1]]);

	}
}
