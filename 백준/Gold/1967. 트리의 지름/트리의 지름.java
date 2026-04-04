import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(st.nextToken());

		List<int[]>[] list = new ArrayList[n + 1];

		for (int i = 0; i < n + 1; i++) {
			list[i] = new ArrayList();
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new int[] { b, c });
			list[b].add(new int[] { a, c });
		}

		boolean[] visited = new boolean[n + 1];
		Queue<int[]> queue = new LinkedList();
		queue.add(new int[] { 1, 0 });
		visited[1] = true;

		int max = 0;
		int idx1 = 0;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			if (now[1] > max) {
				max = now[1];
				idx1 = now[0];
			}
			for (int[] next : list[now[0]]) {
				if (visited[next[0]])
					continue;
				queue.add(new int[] { next[0], now[1] + next[1] });
				visited[next[0]] = true;
			}
		}

		visited = new boolean[n + 1];
		queue = new LinkedList();
		queue.add(new int[] { idx1, 0 });
		visited[idx1] = true;

		max = 0;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			if (now[1] > max) {
				max = now[1];
			}
			for (int[] next : list[now[0]]) {
				if (visited[next[0]])
					continue;
				queue.add(new int[] { next[0], now[1] + next[1] });
				visited[next[0]] = true;
			}
		}

		System.out.print(max);
	}

}
