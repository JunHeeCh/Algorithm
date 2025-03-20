
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] mnk = br.readLine().trim().split(" ");
		int M = Integer.parseInt(mnk[0]);	//y
		int N = Integer.parseInt(mnk[1]);	//x
		int K = Integer.parseInt(mnk[2]);

		board = new int[M][N];

		for (int i = 0; i < K; i++) {
			String[] box = br.readLine().trim().split(" ");
			int c1 = Integer.parseInt(box[0]);
			int r1 = Integer.parseInt(box[1]);
			int c2 = Integer.parseInt(box[2]);
			int r2 = Integer.parseInt(box[3]);

			for (int j = r1; j < r2; j++) {
				for (int k = c1; k < c2; k++) {
					board[j][k] = 1;
				}
			}

		}
		// 입력 완료

		// 모든 지점을 돌면서
		
		List<Integer> list = new ArrayList<>();	//영역 넓이 저장
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 0) {	//아직 결정이 나지 않은 곳이라면 
					int cnt = bfs(M, N, i, j);
					list.add(cnt);
				}
			}
		}
		
		System.out.println(list.size());
		list.sort(null);
		for (Integer integer : list) {
			System.out.print(integer+" ");
		}
		
	}

	private static int bfs(int m, int n, int r, int c) {
		boolean[][] visited = new boolean[m][n];

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {r,c});
		visited[r][c] = true;
		
		int cnt = 1;
		
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {
			
			int[] loc = queue.poll();
			int R = loc[0];
			int C = loc[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = R+dr[i];
				int nc = C+dc[i];
				
				if(nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && board[nr][nc]==0) {
					queue.add(new int[] {nr,nc});
					visited[nr][nc] = true;
					cnt++;
					board[nr][nc] = -1;
				}
				
			}
			
		}//while
		
		return cnt;
		
	}
}
