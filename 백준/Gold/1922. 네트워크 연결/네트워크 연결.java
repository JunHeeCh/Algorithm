
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		int M = Integer.parseInt(br.readLine().trim());

		PriorityQueue<net> pq = new PriorityQueue<>();

		for (int i = 0; i < M; i++) {
			String[] temp = br.readLine().trim().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			int c = Integer.parseInt(temp[2]);

			pq.offer(new net(a, b, c));
		}

		int[] parent = new int[N + 1];

		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		int pick = 0;
		int cost = 0;
		while (pick < N - 1) {
			net now = pq.poll();

			if (findSet(parent, now.from) != findSet(parent, now.to)) {
				pick++;
				union(parent, now.from, now.to);
				cost += now.cost;
			}
		}
		
		System.out.println(cost);

	}

	static void union(int[] parent, int from, int to) {
		parent[findSet(parent, to)] = findSet(parent, from);
	}

	static int findSet(int[] parent, int i) {
		if(parent[i] == i) {
			return i;
		}
		return parent[i] = findSet(parent, parent[i]);
	}
}

class net implements Comparable<net> {
	int from, to, cost;

	net(int from, int to, int cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(net o) {
		return this.cost - o.cost;
	}

}