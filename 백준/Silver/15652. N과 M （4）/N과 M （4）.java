
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] pprint = new int[M];

		make(N, M, pprint, 0, 1);
	}

	private static void make(int n, int m, int[] pprint, int idx, int start) {
		if(idx==m) {
			for (int i = 0; i < pprint.length; i++) {
				System.out.print(pprint[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i <=n; i++) {
			pprint[idx] = i;
			make(n, m, pprint, idx+1, i);
		}
		
		
		
	}
}
