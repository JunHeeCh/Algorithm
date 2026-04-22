import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder pr = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Set<Integer> set = new HashSet();

		st = new StringTokenizer(br.readLine().trim());

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			set.add(num);
		}

		int[] arr = new int[set.size()];
		int idx = 0;
		for (int i : set) {
			arr[idx++] = i;
		}

		Arrays.sort(arr);

		int[] ans = new int[m];

		func(arr, ans, 0, 0);

		System.out.print(pr);
	}

	private static void func(int[] arr, int[] ans, int idx, int st) {
		if (idx == ans.length) {
			for (int i = 0; i < ans.length; i++) {
				pr.append(ans[i] + " ");
			}
			pr.append("\n");
			return;
		}

		for (int i = st; i < arr.length; i++) {
			ans[idx] = arr[i];
			func(arr, ans, idx + 1, i);
		}

	}

}
