
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, L, R, finish;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nlr = br.readLine().trim().split(" ");
		N = Integer.parseInt(nlr[0]);
		L = Integer.parseInt(nlr[1]);
		R = Integer.parseInt(nlr[2]);

		int[][] board = new int[N][N];
		int idx;

		for (int i = 0; i < board.length; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			idx = 0;
			while (st.hasMoreTokens()) {
				board[i][idx++] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력 완료
		boolean[][] visited;
		
		int days = 0;
		
		while (true) {
			visited = new boolean[N][N];
			finish = 0;
			
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					if (!visited[i][j]) {
						bfs(board, visited, i, j);
					}
				}
			}
			
			if(finish==0) {
				break;
			}
			
			days++;

		} // while
		
		System.out.println(days);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void bfs(int[][] board, boolean[][] visited, int i, int j) {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { i, j });
		visited[i][j] = true;

		Queue<int[]> save = new LinkedList<int[]>();
		save.add(new int[] { i, j });
		int total =board[i][j];
		
		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int k = 0; k < dr.length; k++) {
				int nr = now[0] + dr[k];
				int nc = now[1] + dc[k];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (visited[nr][nc])
					continue;
				
				
				int init = board[now[0]][now[1]];
				int next = board[nr][nc];
				int minus = Math.abs(init-next);
				
				if(minus >= L && minus <= R) {
					visited[nr][nc] = true;
					queue.add(new int[] { nr, nc });
					save.add(new int[] { nr, nc });
					total += board[nr][nc];
				}
				
			}
		} // while
		
		int num = save.size();
		
		if(num == 1) {
			return;
		}else {
			finish++;
		}
		
		for (int[] position : save) {
			board[position[0]][position[1]] = total/num;
		}

	}
}
