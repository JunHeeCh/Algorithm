import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		int[] arr = new int[N + 1];
		for (int i = 0; i < N; i++) {
			arr[i + 1] = Integer.parseInt(br.readLine().trim());
		}

		if (N == 1) {
			System.out.print(arr[1]);
			return;
		}

		if (N == 2) {
			System.out.print(arr[1] + arr[2]);
			return;
		}

		int[] dp = new int[N + 1];
		dp[1] = arr[1];
		dp[2] = arr[1] + arr[2];

		for (int i = 3; i <= N; i++) {
			dp[i] = Math.max(Math.max(dp[i - 1], dp[i - 2] + arr[i]), dp[i - 3] + arr[i - 1] + arr[i]);
		}

		System.out.print(dp[N]);

	}

}
