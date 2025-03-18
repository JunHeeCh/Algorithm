import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static Queue<int[]> list = new LinkedList<>();	//익은 토마토 위치를 저장, 한번 영향을 끼친 경우 삭제 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] mn = br.readLine().trim().split(" ");
		int M = Integer.parseInt(mn[0]);
		int N = Integer.parseInt(mn[1]);
		int[][] board = new int[N][M];
		int res = -1;
		int check = 0;	//모두 익은 토마토인지 확인 
		int fin = M*N;	//0이 되면 모두 익은 것 
		boolean[][] visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().trim().split(" ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(temp[j]);
				if(board[i][j]==0) {
					check++;
				}else if (board[i][j]==1) {	//익은 토마토 위치 저장
					list.add(new int[] {i,j, 0});
					fin--;
				}else {
					visited[i][j] = true; //토마토가 없으면 방문처리
					fin--;
				}
			}
		}
		//입력 완료 
		if (check == 0) {
			res = 0;	//모두 익은 토마토인 경우
		}
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		int day = 0;
		
		while (!list.isEmpty()) {
			int[] position = list.poll();
			int r = position[0];
			int c = position[1];
			int days = position[2];
			day = days;
			
			for (int i = 0; i < 4; i++) {
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr >= 0 && nr < N && nc >= 0 && nc < M) {
					//상자 안에 있는 경우
					if(!visited[nr][nc] && board[nr][nc] != 1) {
						//익지 않았는데 아직 방문하지 못했고, 익은 토마토 영향권에 있는 경우
						list.add(new int[] {nr,nc, days+1});
						visited[nr][nc] = true;
						fin--;
						if(fin==0) {
							day++;
							break;
						}
					}
				}
			}
			
		}
		
		if(fin==0) {
			res = day;
		}else if(fin>0) {
			res = -1;
		}
		System.out.println(res);
		
	}
}
