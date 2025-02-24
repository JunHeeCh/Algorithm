import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] loc = sc.nextLine().trim().split(" ");
		int N = Integer.parseInt(loc[0]);
		int K = Integer.parseInt(loc[1]);

		System.out.println(bfs(N, K));

	}

	public static int bfs(int N, int K) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[] visited = new boolean[100001];
		if(N == K) return 0;
		queue.add(new int[] {0,N});
		visited[N] = true;

		while (!queue.isEmpty()) {
			int[] data = queue.poll();
			int cnt = data[0];
			int num = data[1];
			int[] next = { num -1, num + 1, num * 2 };

			for (int i = 0; i < next.length; i++) {
				if (next[i] == K) {
					return cnt + 1;
				} else if (next[i] != K && next[i] < 100001 && next[i] > -1 && !visited[next[i]]) {

					queue.add(new int[] { cnt + 1, next[i] });
					visited[next[i]] = true;
				}
			}

		}
		return -1;

	}

}
