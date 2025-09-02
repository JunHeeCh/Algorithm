import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = { -1, 0, 0, 1 }; // 상 좌 우 하
	static int[] dc = { 0, -1, 1, 0 };
	static int time;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		int[][] board = new int[N][N];

		time = 0;

		int[] count = new int[7];

		fish shark = new fish();

		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().trim().split(" ");
			for (int j = 0; j < temp.length; j++) {
				int num = Integer.parseInt(temp[j]);
				if (num == 0) {
					continue;
				}
				if (num == 9) {
					shark.x = i;
					shark.y = j;
					shark.size = 2;
					continue;
				}
				board[i][j] = num;
				count[num]++;
			}
		}

		// 1. pq에서 나보다 작은 크기의 물고기가 있는지 확인
		// 2. 없으면 종료
		// 3. 있다면 bfs로 탐색 (나보다 같거나 작은 물고기는 통과 가능)

		while (isThereSmallerFish(shark.size, count)) {
			// 먹으면 time 갱신, 사이즈 추가 여부 확인, count 배열 갱신
			if (!bfs(board, shark, count)) {
				break;
			}
		}
		System.out.println(time);
	}

	private static boolean bfs(int[][] board, fish shark, int[] count) {
		// 먹으면 true
		// 못먹으면 false (경로상)
		List<int[]> list = new ArrayList<>();
		int dist = Integer.MAX_VALUE;

		boolean[][] visited = new boolean[board.length][board.length];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { shark.x, shark.y, 0 }); // x,y,이동횟수
		visited[shark.x][shark.y] = true;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int r = now[0];
			int c = now[1];

			if (now[2] > dist)
				break;

			for (int i = 0; i < dr.length; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= board.length || nc < 0 || nc >= board.length || board[nr][nc] > shark.size
						|| visited[nr][nc]) {
					continue;
				}
				
				visited[nr][nc] = true;

				if (board[nr][nc] > 0 && board[nr][nc] < shark.size) {
					// 해당 물고기 잡아먹기 (후보)
					if (dist == Integer.MAX_VALUE) {
						list.add(new int[] { nr, nc, now[2]+1 });
						dist = now[2] + 1;
					} else if (dist == now[2] + 1) {
						list.add(new int[] { nr, nc, now[2]+1 });
					} else {
						break;
					}

				} else {
					queue.add(new int[] { nr, nc, now[2] + 1 });
				}
			}
		}
		
		if(list.isEmpty()) {
			return false;
		}
		
		list.sort((a,b)->{
			if(a[0]!=b[0]) {
				return Integer.compare(a[0], b[0]);
			}
			return Integer.compare(a[1], b[1]);
		});
		
		int[] target = list.get(0);
		
		count[board[target[0]][target[1]]]--;
		time += target[2];
		board[target[0]][target[1]] = 0;
		shark.x = target[0];
		shark.y = target[1];
		
		shark.eaten++;
		if (shark.eaten == shark.size) {
			shark.size++;
			shark.eaten = 0;
		}
		return true;

	}

	private static boolean isThereSmallerFish(int size, int[] count) {

		for (int i = 1; i < size; i++) {
			if(i >= count.length) break;
			if (count[i] > 0) {
				return true;
			}
		}
		return false;
	}

}

class fish implements Comparable<fish> {
	int x;
	int y;
	int eaten;
	int size;

	public fish() {
		// TODO Auto-generated constructor stub
	}

	public fish(int x, int y, int eaten, int size) {
		this.x = x;
		this.y = y;
		this.eaten = eaten;
		this.size = size;
	}

	public int compareTo(fish o) {
		return Integer.compare(this.size, o.size);
	}
}