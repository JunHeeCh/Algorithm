import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int N = Integer.parseInt(st.nextToken());

		int zeros = Integer.parseInt(br.readLine().trim());

		boolean[] num = new boolean[10]; // true이면 사용가능
		for (int i = 0; i < 10; i++) {
			num[i] = true;
		}

		if (zeros != 0) {
			st = new StringTokenizer(br.readLine().trim());

			while (st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				num[n] = false;
			}
		}

		int ans = Math.abs(N - 100);

		for (int i = 0; i <= 999999; i++) {
			if (check(num, i)) {
				int press = String.valueOf(i).length();
				int move = Math.abs(N - i);
				ans = Math.min(ans, press + move);
			}
		}

		System.out.print(ans);
	}

	private static boolean check(boolean[] num, int a) {
		if (a < 0)
			return false;
		char[] arr = (a + "").toCharArray();

		for (int i = 0; i < arr.length; i++) {
			int n = arr[i] - '0';
			if (!num[n]) {
				return false;
			}
		}
		return true;
	}

}
