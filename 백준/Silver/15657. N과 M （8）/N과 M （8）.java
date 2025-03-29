
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int[] pprint = new int[M];

		make(N, M, pprint, 0, 0, arr);
	}

	private static void make(int n, int m, int[] pprint, int idx, int start, int[] arr) {
		if(idx==m) {
			for (int i = 0; i < pprint.length; i++) {
				System.out.print(pprint[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < n; i++) {
				pprint[idx] = arr[i];
				make(n, m, pprint, idx+1, i, arr);
		}
		
		
		
	}
}
