import java.io.*;
import java.util.*;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		
		int[][] board = new int[N][M];
		
		char[] tmp;
		for (int i = 0; i < N; i++) {
			tmp = br.readLine().trim().toCharArray();
			for (int j = 0; j < M; j++) {
				if(tmp[j] == 'U') {
					board[i][j] = 0;
				}else if(tmp[j] == 'D') {
					board[i][j] = 1;
				}else if(tmp[j] == 'L') {
					board[i][j] = 2;
				}else if(tmp[j] == 'R') {
					board[i][j] = 3;
				}
			}
		}
		
		boolean[][] visited = new boolean[N][M];
		int res = 0;
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if(!visited[i][j]) {
					bfs(board, visited,i,j);
					res++;
				}
			}
		}

		System.out.println(res);
	}

	private static void bfs(int[][] board, boolean[][] visited, int r, int c) {
		
		Queue<int[]> queue = new LinkedList();
		queue.add(new int[] {r,c});
		visited[r][c] = true;
		
		while(!queue.isEmpty()) { //나로부터 뻗어나가는 경로
			int[] now = queue.poll();
			
			int nr = now[0]+dr[board[now[0]][now[1]]];
			int nc = now[1]+dc[board[now[0]][now[1]]];
			
			if(nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
				if(!visited[nr][nc]) {
					queue.add(new int[] {nr,nc});
					visited[nr][nc] = true;
				}
			}
			
			for (int i = 0; i < dr.length; i++) {
				int prevr = now[0]+dr[i];
				int prevc = now[1]+dc[i];
				
				if(prevr >= 0 && prevr < board.length && prevc >= 0 && prevc < board[0].length && !visited[prevr][prevc]) {
					if(i+board[prevr][prevc] == 1 || i+board[prevr][prevc] == 5) {
						queue.add(new int[] {prevr,prevc});
						visited[prevr][prevc] = true;
					}
				}
			}
		}
		
		
	}

}
