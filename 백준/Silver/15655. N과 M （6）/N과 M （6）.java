
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(sc.nextInt());
		}
		
		Collections.sort(list);
		int[] pprint = new int[M];

		make(N, M, pprint, 0, 1, list, 0);
	}

	private static void make(int n, int m, int[] pprint, int idx, int start, List<Integer> list, int listno) {
		if(idx==m) {
			for (int i = 0; i < pprint.length; i++) {
				System.out.print(pprint[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = listno; i < n; i++) {
			pprint[idx] = list.get(i);
			make(n, m, pprint, idx+1, i, list, i+1);
		}
		
		
		
	}
}
