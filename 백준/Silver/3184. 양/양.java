import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int wolf = 0;
	static int sheep = 0;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);

		int[][] board = new int[n][m]; // -1 : 울타리, 0 : 빈 필드, 1: 양, 2: 늑대
		boolean[][] visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			temp = br.readLine().trim().split("");
			for (int j = 0; j < m; j++) {
				if (temp[j].equals("#")) {
					board[i][j] = -1;
					visited[i][j] = true;
				} else if (temp[j].equals("v")) {
					board[i][j] = 2;
				} else if (temp[j].equals("o")) {
					board[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (!visited[i][j]) {
					bfs(board, visited, i, j);
				}
			}
		}

		System.out.println(sheep + " "+ wolf);
	}

	private static void bfs(int[][] board, boolean[][] visited, int r, int c) {
		// 갈 수 있는 모든 곳들을 확인하면서 늑대와 양의 수를 계산하자
		int w = 0;
		int s = 0;

		Queue<int[]> queue = new LinkedList();
		queue.add(new int[] { r, c });
		visited[r][c] = true;

		if (board[r][c] == 1) {
			s++;
		} else if (board[r][c] == 2) {
			w++;
		}

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for (int i = 0; i < dr.length; i++) {
				int nr = now[0]+dr[i];
				int nc = now[1]+dc[i];
				
				if(nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && !visited[nr][nc]) {
					if (board[nr][nc] == 1) {
						s++;
					} else if (board[nr][nc] == 2) {
						w++;
					}
					queue.add(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
			
		}
		
		if(s > w) {
			sheep += s;
		}else {
			wolf += w;
		}

	}

}
