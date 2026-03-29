import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine().trim());

		int[] dp = new int[n+1];
		
		if(n==1) {
			System.out.print(3);
			return;
		}else if(n==2) {
			System.out.print(7);
			return;
		}
		
		dp[1] = 3;
		dp[2] = 7;
		
		for(int i=3; i<=n; i++) {
			dp[i] = dp[i-1]*2+dp[i-2];
			dp[i] %= 9901;
		}
		System.out.print(dp[n]);
	}

}