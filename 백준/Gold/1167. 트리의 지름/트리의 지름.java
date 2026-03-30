import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		List<int[]>[] list = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			list[i] = new ArrayList();
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int v = Integer.parseInt(st.nextToken());
			while (st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				if (num == -1) {
					break;
				}
				int dis = Integer.parseInt(st.nextToken());
				list[v].add(new int[] { num, dis });
			}
		}

		int[] ans = dfs(list, 1);
		ans = dfs(list, ans[0]);

		System.out.print(ans[1]);
	}

	private static int[] dfs(List<int[]>[] list, int start) {
		boolean[] visited = new boolean[list.length];
		visited[start] = true;

		Queue<int[]> queue = new LinkedList();
		queue.add(new int[] { start, 0 });

		int[] ans = new int[] { 0, -1 };

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			if (now[1] > ans[1]) {
				ans[0] = now[0];
				ans[1] = now[1];
			}
			for (int[] a : list[now[0]]) {
				if (visited[a[0]]) {
					continue;
				}
				visited[a[0]] = true;
				queue.add(new int[] { a[0], now[1] + a[1] });
			}
		}
		return ans;
	}

}