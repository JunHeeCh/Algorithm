import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//import java.util.StringTokenizer;

public class Main {

	static int ER, EC;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static Queue<int[]> queue;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		int[][] board = new int[N][M];
		for (int i = 0; i < N; i++) {
			String[] st = br.readLine().trim().split("");
//			StringTokenizer sTokenizer = new StringTokenizer(br.readLine().trim(), "");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st[j]);
//				board[i][j] = Integer.parseInt(sTokenizer.nextToken());
				
			}
		}
		// 입력 완료
		res = -1;
		ER = N - 1;
		EC = M - 1;

		bfs(board);
		System.out.println(res);
	}

	private static void bfs(int[][] board) {
		queue = new LinkedList<>();
		queue.add(new int[] { 0, 0, 1, 0 });
		boolean[][][] visited = new boolean[board.length][board[0].length][2];
		visited[0][0][0] = true;
		while (!queue.isEmpty()) {
			int[] rc = queue.poll();
			int r = rc[0];
			int c = rc[1];
			int depth = rc[2];
			int onecnt = rc[3];
			if (r == ER && c == EC) {
				res = depth;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
					if (board[nr][nc] == 1 && onecnt > 0) {
						continue;
					} else if (board[nr][nc] == 1 && onecnt == 0) {
						queue.add(new int[] { nr, nc, depth + 1, onecnt + 1 });
						visited[nr][nc][1] = true;
					} else if (board[nr][nc] == 0&& !visited[nr][nc][onecnt]) {
						queue.add(new int[] { nr, nc, depth + 1 , onecnt});
						visited[nr][nc][onecnt] = true;
					}

				}
			}
		}

	}
}
