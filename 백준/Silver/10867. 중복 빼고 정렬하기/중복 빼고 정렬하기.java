import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		Set<Integer> set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			set.add(sc.nextInt());
		}
		
		int[] arr = new int[set.size()];
		int idx = 0;
		for (Integer i : set) {
			arr[idx++] = i;
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
}
