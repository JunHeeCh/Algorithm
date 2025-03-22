import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nmStrings = bReader.readLine().trim().split(" ");
		
		int N = Integer.parseInt(nmStrings[0]);
		int M = Integer.parseInt(nmStrings[1]);
		
		int[][] board = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String[] tempStrings = bReader.readLine().trim().split(" ");
			for (int j = 0; j < M; j++) {
				board[i][j]=Integer.parseInt(tempStrings[j]); 
			}
		}
		
		int[][] result = new int[N][M];
		
		int[] dr = {0,-1,-1};
		int[] dc = {-1,-1,0};
		
		int res;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				res = 0;
				for(int k = 0; k<3; k++) {
					int nr = i+dr[k];
					int nc = j+dc[k];
					if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
						res = Math.max(res, result[nr][nc]);
					}
				}
				
				result[i][j] = board[i][j]+res;
			}
		}
		
		System.out.println(result[N-1][M-1]);
		
	}
}
