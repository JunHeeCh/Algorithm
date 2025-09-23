import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");

		/*
		 * N개의 땅이 있어 a->b 까지의 거리를 측정해서 C보다 같거나 큰 경우 길을 만들 수 있어 최소 비용으로 모든 땅을 연결하고 싶어
		 */
		int N = Integer.parseInt(temp[0]);
		int C = Integer.parseInt(temp[1]);

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			return Integer.compare(a[2], b[2]);
		});

		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			temp = br.readLine().trim().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);

			arr[i][0] = a;
			arr[i][1] = b;
		}

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				int cost = (int) Math.pow(arr[i][0] - arr[j][0], 2) + (int) Math.pow(arr[i][1] - arr[j][1], 2);
				pq.add(new int[] { i, j, cost });
			}
		}

		int[] parent = new int[N];

		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		int res = 0;
		boolean flag = false;

		while (!pq.isEmpty()) {
			int[] now = pq.poll();
			if (now[2] < C)
				continue;

			// now[0], now[1] 를 잇는 다리를 연결
			// 부모가 동일한지 확인하고
			int p1 = check(now[0], parent);
			int p2 = check(now[1], parent);

			if (p1 != p2) {
				// 부모가 달라
				res += now[2];
				int small = Math.min(p1, p2);

				if (small == p1) {
					parent[p2] = p1;
				} else {
					parent[p1] = p2;
				}

				if (fin(parent)) {
					flag = true;
					break;
				}
			}

		}

		if (!flag) {
			res = -1;
		}
		System.out.print(res);

	}

	private static boolean fin(int[] parent) {
		int standard = check(0, parent);

		for (int i = 1; i < parent.length; i++) {
			if (standard != check(i, parent)) {
				return false;
			}
		}
		return true;
	}

	private static int check(int i, int[] arr) {
		if (arr[i] != i) {
			arr[i] = check(arr[i], arr);
		}
		return arr[i];
	}

}
