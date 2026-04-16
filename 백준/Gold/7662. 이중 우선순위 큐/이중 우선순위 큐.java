import java.io.*;
import java.util.*;

public class Main {
    static int aliveCount = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 0; tc < T; tc++) {
			int k = Integer.parseInt(br.readLine().trim());
			StringTokenizer st;

			Map<Integer, Boolean> map = new HashMap(); // 고유한 id, 생존 여부
			PriorityQueue<int[]> worst = new PriorityQueue<>((a, b) -> {
				return Integer.compare(a[1], b[1]);
			});
			PriorityQueue<int[]> best = new PriorityQueue<>((a, b) -> {
				return Integer.compare(b[1], a[1]);
			});
			int idx = 1;
            aliveCount = 0;
            
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine().trim());
				String op = st.nextToken();
				int n = Integer.parseInt(st.nextToken());
				if (op.equals("D")) {
					if (n == 1) {
						deleteB(map, best, worst);
					} else {
						deleteW(map, best, worst);
					}
				} else if (op.equals("I")) {
					map.put(idx, true);
					best.add(new int[] { idx, n });
					worst.add(new int[] { idx, n });
					idx++;
                    aliveCount++;
				}
			}
			
			if (aliveCount==0) {
				sb.append("EMPTY");
			} else {
                int a = getB(map, best, worst);
			    int b = getW(map, best, worst);
				sb.append(a + " " + b);
			}
			sb.append("\n");
		}

		System.out.print(sb);

	}

	private static int getW(Map<Integer, Boolean> map, PriorityQueue<int[]> best, PriorityQueue<int[]> worst) {
		while (!worst.isEmpty()) {
			if (map.get(worst.peek()[0])) {
				// 살아있음
				return worst.peek()[1];
			} else {
				worst.poll();
			}
		}
		return 0;
	}

	private static int getB(Map<Integer, Boolean> map, PriorityQueue<int[]> best, PriorityQueue<int[]> worst) {
		while (!best.isEmpty()) {
			if (map.get(best.peek()[0])) {
				// 살아있음
				return best.peek()[1];
			} else {
				best.poll();
			}
		}
		return 0;
	}

	private static void deleteW(Map<Integer, Boolean> map, PriorityQueue<int[]> best, PriorityQueue<int[]> worst) {
		while (!worst.isEmpty()) {
			if (map.get(worst.peek()[0])) {
				// 살아있음
				map.put(worst.peek()[0], false);
				worst.poll();
                aliveCount--;
				return;
			} else {
				worst.poll();
			}
		}
	}

	private static void deleteB(Map<Integer, Boolean> map, PriorityQueue<int[]> best, PriorityQueue<int[]> worst) {
		while (!best.isEmpty()) {
			if (map.get(best.peek()[0])) {
				// 살아있음
				map.put(best.peek()[0], false);
				best.poll();
                aliveCount--;
				return;
			} else {
				best.poll();
			}
		}

	}

}
