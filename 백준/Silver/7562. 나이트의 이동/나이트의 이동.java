import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine()); // 판 길이
			String[] tmp = br.readLine().trim().split(" ");
			int s1 = Integer.parseInt(tmp[0]);
			int s2 = Integer.parseInt(tmp[1]);
			tmp = br.readLine().trim().split(" ");
			int g1 = Integer.parseInt(tmp[0]);
			int g2 = Integer.parseInt(tmp[1]);
			// 입력 완

			int times = bfs(N, s1, s2, g1, g2);
			System.out.println(times);
		} // tc
	}

	private static int bfs(int n, int s1, int s2, int g1, int g2) {
		int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };
		boolean[][] visited = new boolean[n][n];
		Queue<int[]> queue = new LinkedList<>();
		int time = 0;
		queue.add(new int[] { s1, s2, time });
		
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int nowR = tmp[0];
			int nowC = tmp[1];
			int times = tmp[2];
			visited[nowR][nowC] = true;
			
			if(nowR==g1 && nowC==g2) {
				return times;
			}
			
			for (int i = 0; i < dr.length; i++) {
				int nextR = nowR+dr[i];
				int nextC = nowC+dc[i];
				if(inBoundary(n, nextR, nextC) && !visited[nextR][nextC]) {
					queue.add(new int[] {nextR,nextC,times+1});
					visited[nextR][nextC] = true;
				}
			}
		}
		return -1;
	}

	public static boolean inBoundary(int n, int p1, int p2) {
		if (p1 >= 0 && p1 < n && p2 >= 0 && p2 < n) {
			return true;
		}
		return false;
	}
}
