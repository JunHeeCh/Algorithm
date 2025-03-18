
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static Queue<int[]> queue = new LinkedList<>();	//익은 토마토 위치를 저장, 한번 영향을 끼친 경우 삭제 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] mn = br.readLine().trim().split(" ");
		int M = Integer.parseInt(mn[0]);
		int N = Integer.parseInt(mn[1]);
		int H = Integer.parseInt(mn[2]);
		int[][][] board = new int[H][N][M];
		int res = -1;
		int check = 0;	//모두 익은 토마토인지 확인 
		int fin = M*N*H;	//0이 되면 모두 익은 것 
		boolean[][][] visited = new boolean[H][N][M];
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				String[] temp = br.readLine().trim().split(" ");
				for (int j = 0; j < M; j++) {
					board[k][i][j] = Integer.parseInt(temp[j]);
					if(board[k][i][j]==0) {
						check++;
					}else if (board[k][i][j]==1) {	//익은 토마토 위치 저장
						queue.add(new int[] {k,i,j, 0});
						fin--;
					}else {
						visited[k][i][j] = true; //토마토가 없으면 방문처리
						fin--;
					}
				}
			}
			
		}
		//입력 완료 
		if (check == 0) {
			res = 0;	//모두 익은 토마토인 경우
		}
		int[] dh = {-1,1,0,0,0,0};	//위,아래, 상하좌우 
		int[] dr = {0,0,-1,1,0,0};
		int[] dc = {0,0,0,0,-1,1};
		int day = 0;
		
		while (!queue.isEmpty()) {
			int[] position = queue.poll();
			int h = position[0];
			int r = position[1];
			int c = position[2];
			int days = position[3];
			day = days;
			
			for (int i = 0; i < 6; i++) {
				int nh = h+dh[i];
				int nr = r+dr[i];
				int nc = c+dc[i];
				if(nr >= 0 && nr < N && nc >= 0 && nc < M && nh >=0 && nh < H) {
					//상자 안에 있는 경우
					if(!visited[nh][nr][nc] && board[nh][nr][nc] != 1) {
						//익지 않았는데 아직 방문하지 못했고, 익은 토마토 영향권에 있는 경우
						queue.add(new int[] {nh,nr,nc, days+1});
						visited[nh][nr][nc] = true;
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
