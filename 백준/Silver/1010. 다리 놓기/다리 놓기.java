import java.io.*;
import java.util.*;

public class Main {

	static long[][] dp = new long[31][31];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine().trim());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			get(a, b);

			System.out.println(dp[b][a]);
		}

	}

	private static long get(int a, int b) {
		if (a == 0 || a == b) {
			return dp[b][a] = 1;
		}

		if (dp[b][a] == 0) {
			dp[b][a] = get(a, b - 1) + get(a - 1, b - 1);
		}
		return dp[b][a];
	}

}
