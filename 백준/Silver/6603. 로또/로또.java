import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int n = sc.nextInt();
			if(n==0) break;
			
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			
			int[] res = new int[6];
			make(arr, res, 0, 0);
			System.out.println();
		}//while
	}

	private static void make(int[] arr, int[] res, int idx, int start) {
		if(idx == 6) {
			for (int i = 0; i < res.length; i++) {
				System.out.print(res[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < arr.length; i++) {
			res[idx] = arr[i];
			make(arr, res, idx+1, i+1);
		}
		
	}
}
