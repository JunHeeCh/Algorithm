import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] building;
	static int W, H;
	static Queue<int[]> bool;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {

			String[] wh = br.readLine().trim().split(" ");
			W = Integer.parseInt(wh[0]);
			H = Integer.parseInt(wh[1]);

			building = new int[H][W];

			bool = new ArrayDeque<>();

			int locR = 0, locC = 0;

			for (int i = 0; i < H; i++) {
				char[] temp = br.readLine().trim().toCharArray();
				for (int j = 0; j < temp.length; j++) {
					if (temp[j] == '#') {
						building[i][j] = -1; // 벽
					} else if (temp[j] == '*') {
						building[i][j] = -10; // 불
						bool.add(new int[] { i, j });
					} else if (temp[j] == '@') {
						locR = i;
						locC = j;
					}
				}
			}
			// 입력 완료
			boolean[][] visited = new boolean[H][W];
			boolean check = false;

			if (locR == 0 || locR == H - 1 || locC == 0 || locC == W - 1) {
				check = true;
				sb.append(1);
			} else {
				Queue<int[]> nextloc = new ArrayDeque<>();
				nextloc.add(new int[] { locR, locC, 0 });
				visited[locR][locC] = true;

				next: while (!nextloc.isEmpty()) {
					int size = nextloc.size();

					burn();

					while (size > 0) {
						size--;
						int[] now = nextloc.poll();
						int r = now[0];
						int c = now[1];

//						if (r > 0 || n < 0)
						if (now[0] == 0 || now[0] == H - 1 || now[1] == 0 || now[1] == W - 1) {
							sb.append(now[2] + 1);
							check = true;
							break next;
						}

						for (int i = 0; i < dr.length; i++) {
							int nr = now[0] + dr[i];
							int nc = now[1] + dc[i];

							if (nr >= 0 && nr < H && nc >= 0 && nc < W) {
								if (building[nr][nc] == -10 || building[nr][nc] == -1 || visited[nr][nc])
									continue;

								visited[nr][nc] = true;
								nextloc.add(new int[] { nr, nc, now[2] + 1 });
							}

						}
					} // curr while

				} // next while

			}

			if (!check) {
				sb.append("IMPOSSIBLE");
			}
			sb.append("\n");
		} // tc

		System.out.println(sb);
	}

	private static void burn() {

		int size2 = bool.size();

		while (size2 > 0) {
			size2--;
			int[] now = bool.poll();

			for (int i = 0; i < dr.length; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];

				if (nr < 0 || nr >= H || nc < 0 || nc >= W)
					continue;
				if (building[nr][nc] == -1 || building[nr][nc] == -10)
					continue;

				building[nr][nc] = -10;
				bool.add(new int[] { nr, nc });

			}
		} // while

	}
}
