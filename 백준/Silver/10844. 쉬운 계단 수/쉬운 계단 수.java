
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long mod = 1000000000;
		int N = sc.nextInt();

		long[][] board = new long[10][N];
		for (int i = 1; i <= 9; i++) {
			board[i][0] = 1;
		}
		
		for (int i = 1; i < N; i++) {
			//각 줄에 값 채우기 board[?][i]
			for (int j = 0; j < 10; j++) {
				int a = j-1;
				int b = j+1;
				if(a>=0 && a<=9) {
					board[a][i] += board[j][i-1];
					board[a][i] %= mod; 
				}
				if(b>=0 && b<=9) {
					board[b][i] += board[j][i-1];
					board[b][i] %= mod; 
				}
			}
		}
		
		long sum = 0;
		for (int i = 0; i <= 9; i++) {
			sum = (sum +board[i][N-1])%mod;
		}
		
		System.out.println(sum);
		
		
	}
}
