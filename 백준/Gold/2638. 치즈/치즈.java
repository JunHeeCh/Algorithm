
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int[][] board;
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().trim().split(" ");
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);

		board = new int[N][M];
		int cnt = 0; // 치즈 칸 수

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0) {
					board[i][j] = -1;
				} else if (board[i][j] == 1) {
					cnt++;
				}
			}
		}

		// 입력 완료

		int days = 0;
		List<int[]> list = new ArrayList<>();

		bfs(N, M, 0, 0); // 외부 공기&내부 공기 구별해주는 메서드

		while (true) {
			if (cnt == 0)
				break;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j] == 1) {
						// 치즈인 경우 확인하기
						int check = 0; // 한면이 외부 공기이면 +1

						for (int k = 1; k < 5; k++) {
							int nr = i + dr[k];
							int nc = j + dc[k];
							if (nr >= 0 && nr < N && nc >= 0 && nc < M && board[nr][nc] == 0) {
								check++;
							}
							if (check > 1) {
								// 두면이 외부 공기와 접촉하면
								list.add(new int[] { i, j });
								cnt--;
								break;
							}
						}

					}
				}
			}

			Set<String> set = new HashSet<>();
			for (int[] is : list) {
				
				board[is[0]][is[1]] = 0;
				
				for (int i = 1; i < 5; i++) {
					int nr = is[0]+dr[i];
					int nc = is[1]+dc[i];
					if(board[nr][nc] == -1) {
						set.add(nr+","+nc);
					}
				}
			}
			

			for (String is : set) {
				String[] st = is.split(",");
				int r = Integer.parseInt(st[0]);
				int c = Integer.parseInt(st[1]);
				if(board[r][c] == -1) {
					bfs(N, M, r, c);
				}
			}
			
			list.clear();

			days++;
		}

		System.out.println(days);

	}

	private static void bfs(int n, int m, int sr, int sc) {

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { sr, sc });

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int r = now[0];
			int c = now[1];

			for (int i = 0; i < 5; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && board[nr][nc] == -1) {
					board[nr][nc] = 0;
					queue.add(new int[] { nr, nc });
				}
			}
		}

	}
}
