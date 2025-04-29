
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	static int[] memo;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		if(N>1) {
			func(N);
			System.out.println(memo[N]);
		}else {
			System.out.println(1);
		}
		

	}// main
	
	static void func(int N){
		memo = new int[N + 1];
		memo[1] = 1;
		memo[2] = 3;
		
		int idx = 3;
		while (idx < N+1) {
			memo[idx] = (memo[idx-1]+(memo[idx-2]*2))%10007;
			idx++;
		}
	}

}
