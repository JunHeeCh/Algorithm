import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = { -1, 0, 0, 1 }; // 상 좌 우 하
	static int[] dc = { 0, -1, 1, 0 };
	static int time;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		int[] time = new int[N];
		int[] profit = new int[N];
		int[] dp = new int[N + 1];

		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().trim().split(" ");
			time[i] = Integer.parseInt(temp[0]);
			profit[i] = Integer.parseInt(temp[1]);
		}

		for (int i = N - 1; i >= 0; i--) {
			if(i-1+time[i] < N) {
				dp[i] = Math.max(dp[i+1], profit[i]+dp[i+time[i]]);
			}else {
				dp[i] = dp[i+1];
			}
		}

		System.out.println(dp[0]);
	}

}
