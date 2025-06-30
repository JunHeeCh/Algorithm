
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 동서남북상하
		int[] dl = new int[] { 0, 0, 0, 0, -1, 1 };
		int[] dr = new int[] { 0, 0, 1, -1, 0, 0 };
		int[] dc = new int[] { 1, -1, 0, 0, 0, 0 };

		// 입력
		while (true) {
			String[] temp = br.readLine().trim().split(" ");
			int L = Integer.parseInt(temp[0]);
			int R = Integer.parseInt(temp[1]);
			int C = Integer.parseInt(temp[2]);

			if (L == 0 && R == 0 && C == 0) {
				break;
			}

			int[][][] building = new int[L][R][C];

			int[] start = new int[3];

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					temp = br.readLine().trim().split("");
					for (int k = 0; k < C; k++) {
						if (temp[k].equals("S")) {
							building[i][j][k] = 10;
							start[0] = i;
							start[1] = j;
							start[2] = k;
						} else if (temp[k].equals("E")) {
							building[i][j][k] = 20;
						} else if (temp[k].equals("#")) {
							building[i][j][k] = -1;
						}
					}
				}
				br.readLine();
			}

			// 로직
			int res = -1;
			boolean[][][] visited = new boolean[L][R][C];
			Queue<int[]> queue = new LinkedList();

			queue.add(new int[] {start[0],start[1],start[2],0});
			visited[start[0]][start[1]][start[2]] = true;

			while (!queue.isEmpty()) {
				int[] now = queue.poll();

				for (int i = 0; i < dl.length; i++) {
					int nl = now[0] + dl[i];
					int nr = now[1] + dr[i];
					int nc = now[2] + dc[i];
					int time = now[3];

					if (nl >= L || nr >= R || nc >= C || nl < 0 || nr < 0 || nc < 0) {
						continue;
					}

					if (building[nl][nr][nc] != -1 && !visited[nl][nr][nc]) {
						visited[nl][nr][nc] = true;
						if(building[nl][nr][nc] == 20) {
							res = time+1;
							break;
						}
						queue.add(new int[] { nl, nr, nc, time+1 });
					}

				}
				if(res != -1) {
					break;
				}
			}

			// 출력
			if(res == -1) {
				System.out.println("Trapped!");
			}else {
				System.out.printf("Escaped in %d minute(s).\n", res);
			}
		}

	}
}