import java.io.*;
import java.util.*;

public class Main {

	static StringBuilder pr = new StringBuilder();
	static Set<String> prev = new HashSet();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine().trim());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int[] ans = new int[m];

		func(arr, ans, 0, 0);

		System.out.print(pr);
	}

	private static void func(int[] arr, int[] ans, int idx, int st) {
		if (idx == ans.length) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < ans.length; i++) {
				sb.append(ans[i] + " ");
			}
			if(!prev.contains(sb.toString())) {
				prev.add(sb.toString());
				pr.append(sb.toString()+"\n");
			}
			return;
		}

		for (int i = st; i < arr.length; i++) {
			ans[idx] = arr[i];
			func(arr, ans, idx + 1, i);
		}
		
	}

}
