import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	static int[] memo = new int[1000001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		
		memo[1] = 1;
		memo[2] = 2;
		
		System.out.println(fibo(N));

	}// main

	private static int fibo(int n) {
		if(memo[n] == 0) {
			memo[n] = (fibo(n-1)+fibo(n-2))%15746;
		}
		return memo[n];
	}



}


