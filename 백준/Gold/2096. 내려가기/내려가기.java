import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		int N = Integer.parseInt(br.readLine().trim());

		int[][] arr = new int[N][3];
		for (int i = 0; i < arr.length; i++) {
			String[] temp = br.readLine().trim().split(" ");
			arr[i][0] = Integer.parseInt(temp[0]);
			arr[i][1] = Integer.parseInt(temp[1]);
			arr[i][2] = Integer.parseInt(temp[2]);
		}

		// 로직
		int[][] max = new int[N][3];
		int[][] min = new int[N][3];

		max[0][0] = min[0][0] = arr[0][0];
		max[0][1] = min[0][1] = arr[0][1];
		max[0][2] = min[0][2] = arr[0][2];

		for (int i = 1; i < max.length; i++) {
			max[i][0] = Math.max(max[i - 1][0], max[i - 1][1]) + arr[i][0];
			max[i][1] = Math.max(max[i - 1][0], Math.max(max[i - 1][1], max[i - 1][2])) + arr[i][1];
			max[i][2] = Math.max(max[i - 1][1], max[i - 1][2]) + arr[i][2];

			min[i][0] = Math.min(min[i - 1][0], min[i - 1][1]) + arr[i][0];
			min[i][1] = Math.min(min[i - 1][0], Math.min(min[i - 1][1], min[i - 1][2])) + arr[i][1];
			min[i][2] = Math.min(min[i - 1][1], min[i - 1][2]) + arr[i][2];
		}

		int res1 = Math.max(max[N - 1][0], Math.max(max[N - 1][1], max[N - 1][2]));
		int res2 = Math.min(min[N - 1][0], Math.min(min[N - 1][1], min[N - 1][2]));

		System.out.println(res1+" "+res2);
	}
}
