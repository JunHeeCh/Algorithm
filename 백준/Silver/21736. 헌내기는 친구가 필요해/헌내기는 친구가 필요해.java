import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);

		char[][] board = new char[N][M];
		boolean[][] visited = new boolean[N][M];

		int dox = 0;
		int doy = 0;

		for (int i = 0; i < N; i++) {
			char[] tmp = br.readLine().trim().toCharArray();
			for (int j = 0; j < M; j++) {
				board[i][j] = tmp[j];
				if (board[i][j] == 'I') {
					dox = i;
					doy = j;
				}
			}
		}

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		Queue<int[]> queue = new LinkedList();
		queue.add(new int[] {dox, doy});
		visited[dox][doy] = true;
		
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int i = 0; i < dr.length; i++) {
				int nr = now[0]+dr[i];
				int nc = now[1]+dc[i];
				
				if(nr <0 || nc <0 || nr >= N || nc >= M || board[nr][nc] == 'X' || visited[nr][nc]) {
					continue;
				}
				queue.add(new int[] {nr,nc});
				visited[nr][nc] = true;
				
				if(board[nr][nc] == 'P') {
					cnt++;
				}
			}
		}
		
		if(cnt == 0) {
			System.out.print("TT");
		}else {
			System.out.print(cnt);
		}

	}

}
