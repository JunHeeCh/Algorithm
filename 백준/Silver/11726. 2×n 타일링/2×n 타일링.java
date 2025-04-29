
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static BigInteger[] memo;

	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		if(N>1) {
			func(N);
			System.out.println(memo[N].remainder(BigInteger.valueOf(10007)));
		}else {
			System.out.println(1);
		}
		

	}// main
	
	static void func(int N){
		memo = new BigInteger[N + 1];
		memo[0] = BigInteger.ONE;
		memo[1] = BigInteger.ONE;
		memo[2] = BigInteger.TWO;
		
		int idx = 3;
		while (idx < N+1) {
			memo[idx] = memo[idx-1].add(memo[idx-2]);
			idx++;
		}
	}

}
