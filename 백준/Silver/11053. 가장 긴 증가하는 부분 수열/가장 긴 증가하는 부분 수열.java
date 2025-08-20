import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());

		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[N];
		dp[0] = 1;
		
		for (int i = 1; i < arr.length; i++) {
			// i번째 요소를 마지막으로 하는 
			int max = 1;
			for (int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) {
					max = Math.max(max, dp[j]+1);
				}
			}
			dp[i] = max;
		}
		
		int res = 0;
		for (int i = 0; i < dp.length; i++) {
			res = Math.max(res, dp[i]);
		}

		System.out.println(res);
	}

	
}
