import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = { -1, 0, 0, 1 }; // 상 좌 우 하
	static int[] dc = { 0, -1, 1, 0 };
	static int fuel;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());
		int acheived = 0;

		int[][] board = new int[N][N]; // 벽은 -1로, 승객은 번호로 1~M

		for (int i = 0; i < board.length; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1) {
					board[i][j] = -1; // 벽
				}
			}
		}

		st = new StringTokenizer(br.readLine().trim());
		int[] taxi = new int[2]; // 택시 위치
		taxi[0] = Integer.parseInt(st.nextToken())-1;
		taxi[1] = Integer.parseInt(st.nextToken())-1;

		int[][] customer = new int[M + 1][4];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			customer[i][0] = Integer.parseInt(st.nextToken())-1;
			customer[i][1] = Integer.parseInt(st.nextToken())-1;
			customer[i][2] = Integer.parseInt(st.nextToken())-1;
			customer[i][3] = Integer.parseInt(st.nextToken())-1;
			board[customer[i][0]][customer[i][1]] = i; // 출발지만 저장
		}

		boolean flag = true;
		
		while (acheived < M) {
			int[] customerNo = getCustomerNo(board, taxi);	// 승객번호 , 승객까지의 거리
			if (customerNo[0] == -1) {
				System.out.println(-1);
				return;
			}
			
//			System.out.println("승객번호:"+customerNo[0]+" 승객까지"+customerNo[1]);
			
			// 출발지로부터 도착지까지의 거리 
			int deliver = getDistance(board, customer[customerNo[0]][0],customer[customerNo[0]][1],customer[customerNo[0]][2],customer[customerNo[0]][3]);
			if(deliver == -1) {
				System.out.println(-1);
				return;
			}
//			System.out.println("도착지까지: "+deliver);
			if(customerNo[1]+deliver <= fuel) {
				// 갈 수 있어 
				// 택시 위치 업데이트 
				taxi[0] = customer[customerNo[0]][2];
				taxi[1] = customer[customerNo[0]][3];
				// 승객 번호도 위치에서 지워야 함 
				board[customer[customerNo[0]][0]][customer[customerNo[0]][1]] = 0;
				// 연료 업데이트
				fuel -= customerNo[1]+deliver;
				fuel += deliver*2;
				// 승객 수 업데이트 
				acheived++;
			}else {
				flag = false;
				break;
			}
			
		}
		
		if(flag) {
			System.out.println(fuel);
		}else {
			System.out.println(-1);
		}

	}

	private static int getDistance(int[][] board, int sr, int sc, int er, int ec) {
		int N = board.length;

		boolean[][] visited = new boolean[N][N];
		Queue<int[]> queue = new LinkedList<>();

		queue.add(new int[] { sr, sc, 0 });
		visited[sr][sc] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			
			if(now[0]==er && now[1]==ec) {
				return now[2];
			}
			
			for (int i = 0; i < dr.length; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || board[nr][nc] == -1) {
					continue;
				}

				queue.add(new int[] { nr, nc, now[2] + 1 });
				visited[nr][nc] = true;
			}
		}

		return -1;
	}

	/*
	 * 거리가 가까운 승객들을 찾아서 해당 승객 넘버를 넘겨줘야 하는데 이때, 거리를 갱신하면, 승객 넘버를 갱신하는 느낌으로 있으면 넘버를,
	 * 아니면 -1을 반환
	 * 
	 */
	private static int[] getCustomerNo(int[][] board, int[] taxi) {

		int customerNo = -1;
		int[] loc = new int[2];

		if (board[taxi[0]][taxi[1]] > 0) {
			customerNo = board[taxi[0]][taxi[1]];
			board[taxi[0]][taxi[1]] = 0;
			return new int[] { customerNo, 0 };
		}

		int dis = -1;

		int N = board.length;
		boolean[][] visited = new boolean[N][N];

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { taxi[0], taxi[1], 0 }); // x, y, 거리
		visited[taxi[0]][taxi[1]] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			for (int i = 0; i < dr.length; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc] || board[nr][nc] == -1) {
					continue;
				}

				if (board[nr][nc] > 0) {
					// 승객인 경우
					if (dis == -1) {
						dis = now[2] + 1; // 거리 갱신
						loc = new int[] { nr, nc };
						customerNo = board[loc[0]][loc[1]];
					} else if (dis == now[2] + 1) {
						if (nr < loc[0] || (nr == loc[0] && nc < loc[1])) {
							loc = new int[] { nr, nc };
							customerNo = board[loc[0]][loc[1]];
						}
					} else {
						return new int[] { customerNo, dis };
					}
				}

				queue.add(new int[] { nr, nc, now[2]+1 });
				visited[nr][nc] = true;
			}
		}

		return new int[] { customerNo, dis };
	}

}
