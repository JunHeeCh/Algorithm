import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);

		int[] num = new int[N];
		long max = 0;
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine().trim());
			max = Math.max(max, num[i]);
		}

		long min = 1;
		max = max * M;
		long time = (min + max) / 2;

		while (min <= max) {
			if (check(num, time, M)) {
				max = time - 1;
			} else {
				min = time + 1;
			}
			time = (min + max) / 2;
		}

		System.out.print(min);

	}

	private static boolean check(int[] num, long time, int max) {
		long total = 0;
		for (int i = 0; i < num.length; i++) {
			total += time / num[i];
			if (total >= max)
				return true;
		}

		return total >= max;

	}

}
