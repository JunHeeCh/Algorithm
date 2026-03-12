import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		long answer = 0;

		st = new StringTokenizer(br.readLine().trim());

		Queue<int[]> queue = new LinkedList();
		Set<Integer> set = new HashSet();

		for (int i = 0; i < n; i++) {
			int water = Integer.parseInt(st.nextToken());
			queue.add(new int[] { water, 0 }); // 위치, 거리
			set.add(water);
		}

		while (!queue.isEmpty() && k > 0) {
			int[] now = queue.poll();
			if (!set.contains(now[0] - 1)) {
				queue.add(new int[] { now[0] - 1, now[1] + 1 });
				set.add(now[0] - 1);
				answer += now[1] + 1;
				k--;
			}
			if (k == 0)
				break;
			if (!set.contains(now[0] + 1)) {
				queue.add(new int[] { now[0] + 1, now[1] + 1 });
				set.add(now[0] + 1);
				answer += now[1] + 1;
				k--;
			}
		}

		System.out.println(answer);
	}

}
