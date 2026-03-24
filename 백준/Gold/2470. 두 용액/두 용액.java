import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int left = 0, right = N-1;
		int min = Integer.MAX_VALUE;
		int ans1 = 0, ans2 = 0;

		while (left < right) {
			int sum = arr[left] + arr[right];
			if (min > Math.abs(sum)) {
				ans1 = arr[left];
				ans2 = arr[right];
				min = Math.abs(sum);
			}
			if (sum > 0) {
				right--;
			} else {
				left++;
			}
		}

		System.out.print(ans1 + " " + ans2);

	}

}