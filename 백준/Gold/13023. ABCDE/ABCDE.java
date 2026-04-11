import java.io.*;
import java.util.*;

public class Main {

	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer>[] list = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		boolean[] visited = new boolean[list.length];

		for (int i = 0; i < N; i++) {
			if (flag)
				break;
			visited[i] = true;
			dfs(visited, list, i, 1);
			visited[i] = false;
		}

		if (flag) {
			System.out.print(1);
		} else {
			System.out.print(0);
		}
	}

	private static void dfs(boolean[] visited, List<Integer>[] list, int a, int cnt) {
		if (flag)
			return;

		if (cnt >= 5) {
			flag = true;
			return;
		}

		for (int i : list[a]) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(visited, list, i, cnt + 1);
				visited[i] = false;
			}
		}

	}

}
