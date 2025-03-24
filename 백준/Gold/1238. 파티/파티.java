
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//1238
public class  Main {
	static int T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nmx = br.readLine().trim().split(" ");

		int N = Integer.parseInt(nmx[0]);
		int M = Integer.parseInt(nmx[1]);
		int X = Integer.parseInt(nmx[2]);

		List<Nodew>[] list = new ArrayList[N + 1];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			String[] temp = br.readLine().trim().split(" ");
			int s = Integer.parseInt(temp[0]);
			int e = Integer.parseInt(temp[1]);
			int t = Integer.parseInt(temp[2]);

			list[s].add(new Nodew(e, t));
		}
		int[] home = new int[N + 1];
		Arrays.fill(home, Integer.MAX_VALUE);

		PriorityQueue<Nodew> pq = new PriorityQueue<Nodew>();
		pq.offer(new Nodew(X, 0));
		home[X] = 0;

		while (!pq.isEmpty()) {
			Nodew curr = pq.poll();

			if (home[curr.my] < curr.cost)
				continue;

			for (Nodew node : list[curr.my]) {
				if (home[node.my] > node.cost + home[curr.my]) {
					home[node.my] = node.cost + home[curr.my];
					pq.offer(new Nodew(node.my, home[node.my]));
				}
			}
		}
		// 파티장에서 집으로 가는 시간 구하기 완료

		// 집에서 파티장 가는 시간 구하기!
		for (int i = 1; i <= N; i++) {
			if (i != X) {
				// i가 시작 집 주소
				// 도착지는 X
				calc(i, X, home[i], list);
			}
		}

		System.out.println(T);

	}

	private static void calc(int i, int x, int wayhome, List<Nodew>[] list) {
		PriorityQueue<Nodew> pq = new PriorityQueue<Nodew>();
		pq.offer(new Nodew(i, 0));

		int[] distance = new int[list.length];
		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[i] = 0;

		while (!pq.isEmpty()) {
			Nodew curr = pq.poll();

			if (distance[curr.my] < curr.cost)
				continue;

			for (Nodew node : list[curr.my]) {
				if (distance[node.my] > node.cost + distance[curr.my]) {
					distance[node.my] = node.cost + distance[curr.my];
					pq.offer(new Nodew(node.my, distance[node.my]));
				}
			}
		}

		if (T < wayhome + distance[x]) {
			T = wayhome + distance[x];
		}

	}
}

class Nodew implements Comparable<Nodew> {
	int my;
	int cost;

	public Nodew(int my, int cost) {
		this.my = my;
		this.cost = cost;
	}

	@Override
	public int compareTo(Nodew o) {
		return Integer.compare(this.cost, o.cost);
	}

}
