import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");

		int M = Integer.parseInt(temp[0]);
		int N = Integer.parseInt(temp[1]);

		int[][] board = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] st = br.readLine().trim().split("");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st[j]);
			}
		}

		int[][] cost = new int[N][M];
		for (int i = 0; i < cost.length; i++) {
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		}

		PriorityQueue<spot> pq = new PriorityQueue<spot>();
		pq.offer(new spot(0, 0, 0));
		cost[0][0] = 0;

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		while (!pq.isEmpty()) {
			spot now = pq.poll();

			if (cost[now.r][now.c] < board[now.r][now.c])
				continue;

			for (int i = 0; i < dc.length; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {

					if (cost[nr][nc] > cost[now.r][now.c] + board[nr][nc]) {
						cost[nr][nc] = cost[now.r][now.c] + board[nr][nc];
						pq.add(new spot(nr, nc, cost[nr][nc]));
					}
				}
			}
		} // while

		System.out.println(cost[N - 1][M - 1]);
	}
}

class spot implements Comparable<spot> {
	int r;
	int c;
	int cost;

	public spot(int r, int c, int cost) {
		this.r = r;
		this.c = c;
		this.cost = cost;
	}

	@Override
	public int compareTo(spot o) {
		return Integer.compare(this.cost, o.cost);
	}

}