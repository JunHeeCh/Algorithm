import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int K = Integer.parseInt(temp[1]);

		int[][] dp = new int[K + 1][N + 1];

		for (int n = 0; n <= N; n++) {
			dp[1][n] = 1;
		}

		for (int i = 2; i <= K; i++) {
			for (int j = 0; j <= N; j++) {
				if (j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
				}
				dp[i][j] %= 1000000000;
			}
		}

		System.out.println(dp[K][N]);
	}

}
