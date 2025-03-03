import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int goal1;
	static int goal2;
	static int min;
	static boolean[][] visited;
	static boolean[][] bfsvisited ;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		visited = new boolean[N][N];
		bfsvisited = new boolean[N][N];
		int start1 = sc.nextInt();
		int start2 = sc.nextInt();
		goal1 = sc.nextInt();
		goal2 = sc.nextInt();

//		// dfs
//		int times = 0;
//		min = N * N;
//		visited[start1][start2] = true;
//		findMin(N, start1, start2, times);
//		if (min == N * N)
//			min = -1;
//		System.out.println(min);

		// bfs
		Queue<int[]> queue = new LinkedList<>();
		System.out.println(bfsFindMin(N, start1, start2, queue));
	}

	public static int bfsFindMin(int N, int s1, int s2, Queue<int[]> queue) {
		// start -> goal 최소 이동 거리
		int[] dr = { -2, -2, 0, 0, 2, 2 };
		int[] dc = { -1, 1, -2, 2, -1, 1 }; // delta search
		int time = 1;
		queue.add(new int[] { s1, s2, time}); // 시작 좌표 넣기
		bfsvisited[s1][s2] = true;

		while (!queue.isEmpty()) {
			int[] pop = queue.poll();
			int nowR = pop[0];
			int nowC = pop[1];
			int times = pop[2];
//			System.out.println(nowR+","+nowC+","+times);
			for (int i = 0; i < dc.length; i++) {
				int newR = nowR + dr[i]; // 새롭게 이동할 위치
				int newC = nowC + dc[i];

				if(newR==goal1 && newC ==goal2) {
					return times;
				}
				if (inBorder(newR, newC, N) && !bfsvisited[newR][newC]) {
					queue.add(new int[] { newR, newC, times + 1 });
					bfsvisited[newR][newC] = true;
				}

			}
		}
		return -1;

	}

	// dfs
	public static void findMin(int N, int s1, int s2, int times) {
		// start -> goal 최소 이동 거리
		int[] dr = { -2, -2, 0, 0, 2, 2 };
		int[] dc = { -1, 1, -2, 2, -1, 1 }; // delta search

		if (times >= min) {
			return; // 탐색 중지
		}

		if (s1 == goal1 && s2 == goal2) {
			// 도착한 경우
			min = times;
			return;
		}

		for (int i = 0; i < dc.length; i++) {
			int newR = s1 + dr[i]; // 새롭게 이동할 위치
			int newC = s2 + dc[i];

			if (inBorder(newR, newC, N) && !visited[newR][newC]) {
				visited[newR][newC] = true;
				System.out.println(newR + "," + newC + "," + times);
				findMin(N, newR, newC, times + 1);
				visited[newR][newC] = false;
			}

		}

	}

	private static boolean inBorder(int newR, int newC, int N) {
		if (newR >= 0 && newR < N && newC >= 0 && newC < N) {
			return true;
		}
		return false;
	}
}
