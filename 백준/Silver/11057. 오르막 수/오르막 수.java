
import java.util.Scanner;

// 11057
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = 10007;
		
		int N = sc.nextInt();
		
		int[][] board = new int[10][N];
		for (int i = 0; i < 10; i++) {
			board[i][0] = 1;
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = j; k < 10; k++) {
					board[k][i] = (board[k][i] +board[j][i-1])%num;
				}
			}
		}
		
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			sum = (sum +board[i][N-1])%num;
		}
		
		System.out.println(sum);
	}
}
