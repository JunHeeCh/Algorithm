import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int K = Integer.parseInt(temp[1]);
		
		int[] coin = new int[N];
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine().trim());
		}
		
		int[] dp = new int[K+1];

		dp[0] = 1;
		
		for(int c:coin) {
			for (int i = 1; i < dp.length; i++) {
				if(i-c>=0)
					dp[i] += dp[i-c];
			}
		}
		

		System.out.println(dp[K]);

	}

}
