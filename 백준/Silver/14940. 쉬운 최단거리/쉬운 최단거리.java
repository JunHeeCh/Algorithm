import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().trim().split(" ");
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);

		int[][] board = new int[N][M];
		
		int[][] res = new int[N][M];
		for (int i = 0; i < res.length; i++) {
			Arrays.fill(res[i], -1);
		}
		
		int r = 0, c = 0;
		for (int i = 0; i < board.length; i++) {
			String[] temp = br.readLine().trim().split(" ");
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = Integer.parseInt(temp[j]);
				if (board[i][j] == 2) {
					r = i;
					c = j;
				}else if(board[i][j]==0) {
					res[i][j] = 0;
				}
			}
		}

		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { r, c, 0 });
		res[r][c] = 0;
		
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		
		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			for (int i = 0; i < dr.length; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && board[nr][nc] > 0 && res[nr][nc] <0) {
					queue.add(new int[] {nr,nc, now[2]+1});
					res[nr][nc] = now[2]+1;
				}

			}

		}//while
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println();
		}

	}
}
