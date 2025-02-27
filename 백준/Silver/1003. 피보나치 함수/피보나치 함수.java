import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	
	static Map<Integer, int[]> map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		map = new HashMap<>();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			System.out.println(fibo(N)[0]+" "+fibo(N)[1]);
		} // tc
	}

	public static int[] fibo(int n) {
		int[] zeroOne = new int[2];
		if(n ==1 ) {
			zeroOne[0] = 0;
			zeroOne[1] = 1;
			map.put(1, zeroOne);
			return zeroOne;
		}else if(n==0) {
			zeroOne[0] = 1;
			zeroOne[1] = 0;
			map.put(0, zeroOne);
			return zeroOne;
		}

		if(map.containsKey(n)) {
			return map.get(n);
		}else {
			int[] tmp = fibo(n-1);
			int[] tmp2 = fibo(n-2);
			zeroOne[0] = tmp[0]+tmp2[0];
			zeroOne[1] = tmp[1]+tmp2[1];
			map.put(n, zeroOne);
			return zeroOne;
		}
			
		
	}
}
