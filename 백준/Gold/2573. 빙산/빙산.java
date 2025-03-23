
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//2573
public class Main {

	static int[][] board;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().trim().split(" ");

		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);

		board = new int[N][M];

		int bergcnt = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] > 0) {
					bergcnt++;
				}
			}
		}
		// 입력 완료

		List<int[]> list = new ArrayList<>();
		int tempcnt;
		int days = 0;
		int check = 0;

		while (true) {

			if (bergcnt == 0)
				break;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j] > 0) {
						tempcnt = 0;

						for (int k = 0; k < dr.length; k++) {
							int nr = i + dr[k];
							int nc = j + dc[k];
							if (nr >= 0 && nr < N && nc >= 0 && nc < M && board[nr][nc] == 0) {
								tempcnt++;
							}
						} // 사방탐색

						list.add(new int[] { i, j, tempcnt });
					}
				}
			}

			for (int[] is : list) {
				board[is[0]][is[1]] -= is[2];
				if (board[is[0]][is[1]] <= 0) {
					board[is[0]][is[1]] = 0;
					bergcnt--;
				}
			}

			list.clear();
			days++;

			if (check(bergcnt)) {
				check++;
				break;
			}

		} // while

		if(check==0) {
			System.out.println(0);
		}else {
			System.out.println(days);
		}

	}

	private static boolean check(int bergcnt) {

		boolean[][] visited = new boolean[board.length][board[0].length];
		Queue<int[]> queue = new LinkedList<>();
		int cnt = 0;
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] > 0) {
					queue.add(new int[] { i, j });
					visited[i][j] = true;
					cnt++;
					break;
				}
			}
			if(cnt>0) break;
		}

		while (!queue.isEmpty()) {

			int[] now = queue.poll();

			for (int i = 0; i < dr.length; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];
				if(nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && board[nr][nc] > 0 && !visited[nr][nc]) {
					queue.add(new int[] {nr,nc});
					visited[nr][nc] = true;
					cnt++;
				}
			}

		}
		
		if(bergcnt==cnt) {
			return false;
		}

		return true;
	}
}
