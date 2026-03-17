import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer>[] list = new ArrayList[N + 1];
		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		Queue<int[]> queue = new LinkedList();
		boolean[] visited = new boolean[N + 1];
		visited[1] = true;
		queue.add(new int[] { 1, 0 }); // 번호, 거리

		int max = 0;
		List<Integer> answer = new ArrayList();

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			if (max < now[1]) {
				max = now[1];
				answer = new ArrayList();
				answer.add(now[0]);
			} else if (max == now[1]) {
				answer.add(now[0]);
			}

			for (int i : list[now[0]]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(new int[] { i, now[1] + 1 });
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i : answer) {
			if (min > i) {
				min = i;
			}
		}
		System.out.println(min + " " + max + " " + answer.size());
	}

}
