import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<node>[] list = new ArrayList[N + 1];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			list[a].add(new node(b, c));
			list[b].add(new node(a, c));
		}

		st = new StringTokenizer(br.readLine().trim());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		long[] dist = new long[N + 1];

		Arrays.fill(dist, Long.MIN_VALUE);

		dist[start] = Long.MAX_VALUE;

		PriorityQueue<node> pq = new PriorityQueue();
		pq.add(new node(start, Long.MAX_VALUE));

		while (!pq.isEmpty()) {
			node now = pq.poll();

			if (dist[now.island] > now.weight)
				continue;

			for (node next : list[now.island]) {
				long cost = Math.min(dist[now.island], next.weight);
				if (dist[next.island] < cost) { 
					dist[next.island] = cost;
					pq.add(new node(next.island, cost));
				}
			}

		}

		System.out.println(dist[end]);

	}
}

class node implements Comparable<node> {
	int island;
	long weight;

	public node(int island, long weight) {
		this.island = island;
		this.weight = weight;
	}

	public int compareTo(node o) {
		return Long.compare(o.weight, this.weight);
	}
}