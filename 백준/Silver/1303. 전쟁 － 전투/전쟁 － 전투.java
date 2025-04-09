import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] board;
	static boolean[][] visited;
	static int mycnt, youcnt;
	static int N,M;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().trim().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);

		board = new int[M][N];
		for (int i = 0; i < board.length; i++) {
			char[] temp = br.readLine().trim().toCharArray();
			for (int j = 0; j < board[0].length; j++) {
				if (temp[j] == 'W') {
					board[i][j] = 1;
				} else {
					board[i][j] = 2;
				}
			}
		}
		// 입력 완료

		visited = new boolean[M][N];
		mycnt = 0;
		youcnt = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (!visited[i][j]) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(mycnt+" "+youcnt);

	}

	private static void bfs(int i, int j) {
		int color = board[i][j];
		visited[i][j] = true;
		
		int count = 1;
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for (int k = 0; k < dr.length; k++) {
				int nr = now[0]+dr[k];
				int nc = now[1]+dc[k];
				if(nr >= 0 && nr < M && nc >= 0 && nc < N && !visited[nr][nc] && board[nr][nc] == color) {
					visited[nr][nc] = true;
					count++;
					queue.add(new int[] {nr,nc});
				}
			}//델타탐색
		}//while
		
		if(color == 1) {
			mycnt += count*count;
		}else {
			youcnt += count*count;
		}
		
	}
}
