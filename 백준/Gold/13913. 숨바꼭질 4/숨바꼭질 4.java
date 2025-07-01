import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {

		// 입력
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int max = Math.max(N, K);

		int[] arr = new int[max*2];

		int[] history = new int[max*2];

		// 로직
		if (N == K) {
			System.out.println(0);
			System.out.println(N);
		} else {
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(N);

			while (!queue.isEmpty()) {
				int now = queue.poll();

				if (now + 1 < arr.length && arr[now + 1] == 0 && now + 1 != N) {
					arr[now + 1] = arr[now] + 1;
					history[now + 1] = now;

					if (now + 1 == K) {
						break;
					}
					queue.add(now + 1);
				}

				if (now - 1 >= 0 && arr[now - 1] == 0 && now - 1 != N) {
					arr[now - 1] = arr[now] + 1;
					history[now - 1] = now;
					if (now - 1 == K) {
						break;
					}
					queue.add(now - 1);
				}

				if (now * 2 < arr.length && arr[now * 2] == 0 && now * 2 != N) {
					arr[now * 2] = arr[now] + 1;
					history[now * 2] = now;
					if (now * 2 == K) {
						break;
					}
					queue.add(now * 2);
				}

			}

			// 출력
			
			System.out.println(arr[K]);
			
			ArrayList<Integer> path = new ArrayList<>();
			
			int start = K;
			while (start != N) {
				path.add(start);
				start = history[start];
			}
			path.add(N);
			for (int i = path.size()-1; i >= 0; i--) {
				System.out.print(path.get(i));
                if (i > 0) System.out.print(" ");
			}

		}

	}
}