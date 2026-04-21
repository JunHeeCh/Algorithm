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

		st = new StringTokenizer(br.readLine().trim());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int[] ans = new int[m];
		boolean[] visited = new boolean[n];

		func(visited, arr, ans, 0);

		System.out.print(pr);
	}

	private static void func(boolean[] visited, int[] arr, int[] ans, int idx) {
		if (idx == ans.length) {
			for (int i = 0; i < ans.length; i++) {
				pr.append(ans[i] + " ");
			}
			pr.append("\n");
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (visited[i])
				continue;
			if (i > 0 && arr[i] == arr[i - 1] && !visited[i - 1])
				continue;

			visited[i] = true;
			ans[idx] = arr[i];
			func(visited, arr, ans, idx + 1);
			visited[i] = false;

		}

	}

}
