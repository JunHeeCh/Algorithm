
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");

		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);

		int[][] board = new int[N][M];

		for (int i = 0; i < N; i++) {
			temp = br.readLine().trim().split(" ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(temp[j]);
			}
		}

		boolean[][] visited = new boolean[N][M];
		max = 0;
		int count = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (!visited[i][j] && board[i][j] == 1) {
					bfs(visited, board, i, j);
					count++;
				}
			}
		}
		
		System.out.println(count);
		System.out.println(max);

	}

	private static void bfs(boolean[][] visited, int[][] board, int r, int c) {
		Queue<int[]> queue = new LinkedList();
		queue.add(new int[] {r,c});
		visited[r][c] = true;
		int cnt = 1;
		
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for (int i = 0; i < dr.length; i++) {
				int nr = now[0]+dr[i];
				int nc = now[1]+dc[i];
				
				if(nr<0 || nr >= board.length || nc <0 || nc >= board[0].length) continue;
				
				if(board[nr][nc]==1 && !visited[nr][nc]) {
					queue.add(new int[] {nr,nc});
					visited[nr][nc] = true;
					cnt++;
				}
			}
		}
		max = Math.max(max, cnt);
	}
}
