import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<int[]>[] list = new ArrayList[N + 1];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[a].add(new int[] { b, c });
			list[b].add(new int[] { a, c });
		}

		int[] dist = new int[N + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			return Integer.compare(a[1], b[1]);
		});

		pq.add(new int[] { 1, 0 });
		dist[1] = 0;

		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			int des = now[0];
			int w = now[1];

			if (dist[des] < w)
				continue;

			for (int[] next : list[des]) {
				if(dist[des]+next[1] < dist[next[0]]) {
					dist[next[0]] = dist[des]+next[1];
					pq.add(new int[] {next[0], dist[next[0]]});
				}
			}
		}

		System.out.println(dist[N]);

	}

}
