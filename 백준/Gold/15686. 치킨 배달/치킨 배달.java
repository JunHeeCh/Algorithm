import java.util.*;
import java.io.*;

public class Main {
	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };
	static List<int[]> shutdownList = new ArrayList();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] board = new int[N][N];
		List<int[]> chickenList = new ArrayList();
		List<int[]> homeList = new ArrayList();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2) {
					chickenList.add(new int[] { i, j });
				} else if (board[i][j] == 1) {
					homeList.add(new int[] { i, j });
				}
			}
		}

		int choose = chickenList.size() - M;

		// choose개 골라서 폐업시켜 보고 치킨 거리 값을 계산해보자
		int[] shutdown = new int[choose];

		getShutList(shutdown, 0, 0, chickenList.size());

		int min = Integer.MAX_VALUE;

		for (int[] arr : shutdownList) {
			// arr에 있는 치킨집을 모두 폐업시켜서
			for (int i = 0; i < arr.length; i++) {
				int[] down = chickenList.get(arr[i]);
				board[down[0]][down[1]] = 0;
			}
			// 치킨 거리 값을 구해
			int sum = 0;

			for (int[] home : homeList) {
				sum += getDist(board, home[0], home[1], N);
			}

			min = Math.min(sum, min);

			// 원복
			for (int i = 0; i < arr.length; i++) {
				int[] down = chickenList.get(arr[i]);
				board[down[0]][down[1]] = 2;
			}
		}

		System.out.println(min);
	}

	private static void getShutList(int[] arr, int idx, int start, int N) {
		if (idx == arr.length) {
			shutdownList.add(arr.clone());
			return;
		}

		for (int i = start; i < N; i++) {
			arr[idx] = i;
			getShutList(arr, idx + 1, i + 1, N);
		}

	}

	public static int getDist(int[][] board, int r, int c, int N) {
		// r,c 로부터 가장 가까운 치킨집 거리 보내주기
		int minDist = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 2) {
					int dis = Math.abs(r - i) + Math.abs(c - j);
					minDist = Math.min(minDist, dis);
				}
			}
		}

		return minDist;
	}

}
