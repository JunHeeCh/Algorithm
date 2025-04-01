import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);

		List<Integer>[] lists = new ArrayList[N + 1];
		for (int i = 1; i < lists.length; i++) {
			lists[i] = new ArrayList<>();
		}

		int[] depth = new int[N + 1];

		for (int i = 0; i < M; i++) {
			String[] tm = br.readLine().trim().split(" ");
			int a = Integer.parseInt(tm[0]);
			int b = Integer.parseInt(tm[1]);
			lists[a].add(b);
			depth[b]++;
		}

		boolean[] visited = new boolean[N+1];
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < depth.length; i++) {
			if (depth[i] == 0) {
				queue.add(i);
				break;
			}
		}

		while (!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now+" ");
			visited[now] = true;

			for (int n : lists[now]) {
				depth[n]--;
			}
			
			for (int i = 1; i < depth.length; i++) {
				if (!visited[i] && depth[i] == 0) {
					queue.add(i);
					break;
				}
			}
		}

		System.out.println(sb);

	}
}
