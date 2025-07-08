import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			String[] temp = br.readLine().trim().split(" ");
			int n = Integer.parseInt(temp[0]);
			int d = Integer.parseInt(temp[1]);
			int c = Integer.parseInt(temp[2]);

			int[] dis = new int[n + 1];

			List<int[]>[] list = new ArrayList[n + 1];

			for (int i = 1; i < list.length; i++) {
				list[i] = new ArrayList<>();
			}

			for (int i = 0; i < d; i++) {
				temp = br.readLine().trim().split(" ");
				int a = Integer.parseInt(temp[0]);
				int b = Integer.parseInt(temp[1]);
				int s = Integer.parseInt(temp[2]);

				list[b].add(new int[] { a, s });
			}

			Arrays.fill(dis, Integer.MAX_VALUE);

			PriorityQueue<node> pq = new PriorityQueue<>();
			pq.add(new node(c, 0));
			dis[c] = 0;

			boolean[] visited = new boolean[n + 1];

			while (!pq.isEmpty()) {
				node now = pq.poll();

				if (visited[now.idx]) {
					continue;
				}

				visited[now.idx] = true;

				for (int[] next : list[now.idx]) {
					if (dis[now.idx] + next[1] < dis[next[0]]) {
						dis[next[0]] = dis[now.idx] + next[1];
						pq.add(new node(next[0], dis[next[0]]));
					}
				}

			}

			int count = 0;
			int time = 0;

			for (int i = 1; i < visited.length; i++) {
				if (visited[i]) {
					count++;
					time = Math.max(time, dis[i]);
				}
			}

			System.out.println(count + " " + time);

		} // tc

	}

}

class node implements Comparable<node> {
	int idx;
	int time;

	public node(int idx, int time) {
		this.idx = idx;
		this.time = time;
	}

	@Override
	public int compareTo(node o) {
		return Integer.compare(this.time, o.time);
	}

}
