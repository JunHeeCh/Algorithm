
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int[][] board;
	//사방 탐색 
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//입력 받기
		String[] nm = br.readLine().trim().split(" ");
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);
		
		board = new int[N][M];
		
		int cheeseCnt = 0;	//전체 치즈의 개수 
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().trim().split(" ");
			
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(temp[j]);
				
				if(board[i][j] == 0) {
					board[i][j] = -1;
				}else if(board[i][j] == 1) {
					cheeseCnt++;
				}
			}
		}
		//bfs로 외부 공기를 0으로 저장해주기 
		bfs(N,M); //지도 완성!
		
		//치즈 녹인 날짜를 기록할 리스트 
		List<List<int[]>> list = new ArrayList<>();
		
		while (cheeseCnt != 0) {
			
			List<int[]> temp = new ArrayList<>();
			
			//모든 노드를 탐색하면서 치즈를 녹여주기 ->하루씩 
			for (int i = 1; i < N-1; i++) {
				for (int j = 1; j < M-1; j++) {
				
					if(board[i][j] == 1) {	//치즈인 경우
						//주변에 외부 공기가 있는지 확인 
						for (int k = 0; k < 4; k++) {
							int nr = i+dr[k];
							int nc = j+dc[k];
							if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
								//범위 내에 있고, 외부 공기가 인접해 있으면 
								if(board[nr][nc] == 0) {
									temp.add(new int[] {i,j});
									break;
								}
							}
						}//사방탐색 반복문
						
					}
					
				}
			}
			
			cheeseCnt -= temp.size();
			list.add(temp);
			//해당 일차 치즈 녹이기 
			for (int[] loc : temp) {
				int r=loc[0];
				int c=loc[1];
				board[r][c] = 0;
			}
			bfs(N, M);
		}//while
		
		int time = list.size();
		int hour = list.get(time-1).size();
		
		System.out.println(time);
		System.out.println(hour);
	}

	private static void bfs(int n, int m) {
		boolean[][] visited = new boolean[n][m];
		
		Queue<int[]> queue = new LinkedList<>();
		
		//시작 지점 설정하기 
		queue.add(new int[] {0,0});
		visited[0][0] = true;
		board[0][0] = 0;
		
		while (!queue.isEmpty()) {
			int[] position = queue.poll();
			int r = position[0];
			int c = position[1];
			
			for (int i = 0; i < 4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr >= 0 && nr < n && nc >= 0 && nc < m && board[nr][nc] != 1 &&!visited[nr][nc]) {
					queue.add(new int[] {nr,nc});
					board[nr][nc] = 0;
					visited[nr][nc] = true;
				}
			}
		}
	}
}
