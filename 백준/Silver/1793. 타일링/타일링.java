import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;


public class Main {

	static BigInteger[] memo = new BigInteger[251];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		memo[0] = BigInteger.ONE;
		memo[1] = BigInteger.ONE;
		memo[2] = BigInteger.valueOf(3);
		
		String line = null;
		while ((line = br.readLine())!= null) {
			
//			StringTokenizer st= new StringTokenizer(br.readLine().trim());
//			if(st.hasMoreTokens()) {
				int N = Integer.parseInt(line);
				System.out.println(fibo(N));
//			}else {
//				break;
//			}
		}

	}// main

	private static BigInteger fibo(int n) {
		if(memo[n] == null) {
			memo[n] = fibo(n-1).add(fibo(n-2).multiply(BigInteger.valueOf(2)));
		}
		return memo[n];
	}

//f(n) = f(n-1)+f(n-2)*2;

}


