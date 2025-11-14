import java.util.*;
import java.io.*;

public class Main {

	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		int[] std = new int[N];

		String[] temp = br.readLine().trim().split(" ");
		for (int i = 0; i < N; i++) {
			std[i] = Integer.parseInt(temp[i]);
		}

		int[] test = new int[N];
		boolean[] visited = new boolean[N];

		make(std, test, 0, visited);

	}

	private static void make(int[] std, int[] test, int idx, boolean[] visited) {
		if (flag)
			return;

		if (idx >= test.length) {
			if (check(test, std)) {
				for (int i = 0; i < test.length; i++) {
					System.out.print(test[i] + 1 + " ");
				}
				flag = true;
			}
			return;
		}

		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				test[idx] = i;
				make(std, test, idx + 1, visited);
				visited[i] = false;
			}
		}

	}

	private static boolean check(int[] test, int[] std) {
		for (int i = 0; i < test.length; i++) {
			int cnt = 0;
			int standard = std[test[i]];

			for (int j = 0; j < i; j++) {
				if (test[j] > test[i]) {
					cnt++;
				}
			}

			if (cnt != standard) {
				return false;
			}

		}

		return true;

	}

}
