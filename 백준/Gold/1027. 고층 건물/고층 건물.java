import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		long[] building = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		for (int i = 0; i < N; i++) {
			building[i] = Long.parseLong(st.nextToken());
		}

		int res = 0;
		int[] right = new int[N];
		int[] left = new int[N];

		double standard;

		for (int i = 0; i < right.length; i++) {
			// i번 높이와 j번 높이의 기울기를 확인하라
			int cnt = 0;
			standard = -1000000000;
			for (int j = i + 1; j < right.length; j++) {
				double inclination = (double)(building[j] - building[i]) / (j - i);
				if (inclination > standard) {
					standard = inclination;
					cnt++;
				}
			}
			right[i] = cnt;
		}


		for (int i = 0; i < left.length; i++) {
			int cnt = 0;
			standard = 1000000000;
			for (int j = i - 1; j >= 0; j--) {
				double inclination = (double)(building[j] - building[i]) / (j - i);
				if (inclination < standard) {
					standard = inclination;
					cnt++;
				}
			}
			left[i] = cnt;
		}

		for (int i = 0; i < left.length; i++) {
			res = Math.max(res, right[i] + left[i]);
		}
		System.out.println(res);
	}

}
