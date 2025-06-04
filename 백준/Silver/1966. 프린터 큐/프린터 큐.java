import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			String[] nm = br.readLine().trim().split(" ");
			int N = Integer.parseInt(nm[0]);
			int M = Integer.parseInt(nm[1]);

			Queue<print> queue = new LinkedList();
			int[] arr = new int[10];

			String[] temp = br.readLine().trim().split(" ");

			for (int i = 0; i < N; i++) {
				queue.add(new print(i, Integer.parseInt(temp[i])));
				arr[Integer.parseInt(temp[i])]++;
			}

			print now = queue.poll();
			int count = 0;
			int priority = now.pri;

			while (true) {
				if (check(priority, arr)) {
					// 현재가 가장 우선순위가 높다 == 제거해라
					count++;
					if(now.idx == M) {
						break;
					}
					arr[priority]--;
				}else {
					queue.add(now);
				}
				now = queue.poll();
				priority = now.pri;
			}
			System.out.println(count);
		} // tc

	}

	private static boolean check(int priority, int[] arr) {
		for (int i = priority + 1; i <= 9; i++) {
			if (arr[i] > 0) {
				return false;
			}
		}
		return true;
	}
}

class print {
	int idx;
	int pri;

	print(int idx, int pri) {
		this.idx = idx;
		this.pri = pri;
	}

}