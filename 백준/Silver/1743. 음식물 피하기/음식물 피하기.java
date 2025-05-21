
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int max;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		int K = Integer.parseInt(temp[2]);
		
		int[][] board = new int[N][M];
		
		for (int i = 0; i < K; i++) {
			String[] tmp = br.readLine().trim().split(" ");
			int a = Integer.parseInt(tmp[0])-1;
			int b = Integer.parseInt(tmp[1])-1;
			
			board[a][b] = 1;
		}
		
		max = 0;
		boolean[][] visited = new boolean[N][M];
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(board[i][j]==1 && !visited[i][j]) {
					bfs(board, visited, i, j);
				}
			}
		}
		
		System.out.println(max);
		
	}

	private static void bfs(int[][] board, boolean[][] visited, int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		int count = 0;
		
		queue.add(new int[] {r,c});
		visited[r][c] = true;
		count++;
		
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for (int i = 0; i < dr.length; i++) {
				int nr = now[0]+dr[i];
				int nc = now[1]+dc[i];
				if(nr<0 || nc <0 || nr>= board.length || nc >= board[0].length || visited[nr][nc] || board[nr][nc]==0) {
					continue;
				}
				
				queue.add(new int[] {nr,nc});
				visited[nr][nc] = true;
				count++;
			}
		}
		
		max = Math.max(max, count);
	}
	
	
	
}
