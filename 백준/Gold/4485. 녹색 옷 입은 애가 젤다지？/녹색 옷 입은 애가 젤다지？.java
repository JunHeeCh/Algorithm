
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 1;
		while (true) {
			int N = Integer.parseInt(br.readLine().trim());
			if (N == 0)
				break;

			int[][] board = new int[N][N];

			for (int i = 0; i < N; i++) {
				String[] st = br.readLine().trim().split(" ");
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st[j]);
				}
			}

			int[][] cost = new int[N][N];
			for (int i = 0; i < cost.length; i++) {
				Arrays.fill(cost[i], N * N * 10);
			}

			PriorityQueue<zel> pq = new PriorityQueue<>();
			pq.offer(new zel(0, 0, board[0][0]));
			cost[0][0] = board[0][0];

			while (!pq.isEmpty()) {
				zel now = pq.poll();

				if (cost[now.r][now.c] < now.cost)
					continue;

				for (int i = 0; i < dr.length; i++) {
					int nr = now.r + dr[i];
					int nc = now.c + dc[i];

					if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
						if (cost[nr][nc] > cost[now.r][now.c] + board[nr][nc]) {
							cost[nr][nc] = cost[now.r][now.c] + board[nr][nc];
							pq.offer(new zel(nr, nc, cost[nr][nc]));
						}
					}
				}

			}

			System.out.println("Problem " + tc + ": " + cost[N - 1][N - 1]);
			tc++;
		} // while

	}
}

class zel implements Comparable<zel> {
	int r;
	int c;
	int cost;

	public zel(int r, int c, int cost) {
		this.r = r;
		this.c = c;
		this.cost = cost;
	}

	@Override
	public int compareTo(zel o) {
		return Integer.compare(this.cost, o.cost);
	}

}