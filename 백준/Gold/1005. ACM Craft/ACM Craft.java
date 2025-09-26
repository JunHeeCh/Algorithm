import java.io.*;
import java.util.*;

public class Main {
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());

			int N = Integer.parseInt(st.nextToken()); // 건물 개수
			int K = Integer.parseInt(st.nextToken()); // 큐칙 수

			int[] time = new int[N + 1];
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 1; j < time.length; j++) {
				time[j] = Integer.parseInt(st.nextToken());
			}

			List<Integer>[] list = new ArrayList[N + 1];
			for (int j = 0; j < list.length; j++) {
				list[j] = new ArrayList();
			}

			int[] needed = new int[N + 1];

			for (int j = 0; j < K; j++) {
				// 건설순서 x,y
				// y를 짓기 위해서는 x가 필요하다
				st = new StringTokenizer(br.readLine().trim());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				list[x].add(y);
				needed[y]++;
			}

			int W = Integer.parseInt(br.readLine().trim());

			int[] dp = new int[N + 1];

			Queue<Integer> queue = new LinkedList<>();

			for (int j = 1; j < needed.length; j++) {
				if (needed[j] == 0) {
					queue.add(j);
					dp[j] = time[j];
				}
			}

			while (!queue.isEmpty()) {
				int now = queue.poll();

				for (Integer integer : list[now]) {
					dp[integer] = Integer.max(dp[integer], dp[now] + time[integer]);
					needed[integer]--;
					if (needed[integer] == 0) {
						queue.add(integer);
					}
				}

			}

			System.out.println(dp[W]);
		}

	}

}
