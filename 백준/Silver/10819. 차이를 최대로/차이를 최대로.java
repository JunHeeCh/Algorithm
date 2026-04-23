import java.io.*;
import java.util.*;

public class Main {

	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine().trim());

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] ans = new int[n];
		boolean[] visited = new boolean[n];

		func(arr, ans, visited, 0);

		System.out.print(max);
	}

	private static void func(int[] arr, int[] ans, boolean[] visited, int idx) {
		if (idx == ans.length) {
			int sum = 0;
			for (int i = 1; i < ans.length; i++) {
				sum += Math.abs(ans[i] - ans[i - 1]);
			}
			max = Math.max(max, sum);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				ans[idx] = arr[i];
				func(arr, ans, visited, idx + 1);
				visited[i] = false;
			}
		}

	}

}
