import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		int[] arr = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());
			arr[i + 1] = temp;
		}

		int[] best = new int[N + 1];

		best[1] = arr[1];

		for (int i = 2; i < best.length; i++) {
			int max = arr[i];
			for (int j = 1; j <= i / 2; j++) {
				max = Math.max(max, best[j] + best[i - j]);
			}
			best[i] = max;
		}

		System.out.println(best[N]);

	}

}
