import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine().trim());

			int n = Integer.parseInt(st.nextToken());

			int[][] arr = new int[n][2];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine().trim());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr, (a, b) -> {
				return Integer.compare(a[0], b[0]);
			});

			int ans = 1;
			int min = arr[0][1];

			for (int i = 1; i < arr.length; i++) {
				if (arr[i][1] < min) {
					ans++;
					min = arr[i][1];
				}
			}

			System.out.println(ans);
		}

	}

}
