import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		boolean[] arr = new boolean[10001];

		for (int i = 2; i < arr.length; i++) {
			for (int j = 2; j < arr.length; j++) {
				if (i * j >= arr.length)
					break;
				arr[i * j] = true;
			}
		}

		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine().trim());
			int min = 10002;
			int a = 0, b = 0;
			for (int i = 2; i <= n / 2; i++) {
				if (!arr[i] && !arr[n - i]) {
					if (min > n - 2 * i) {
						min = n - 2 * i;
						a = i;
						b = n - i;
					}
				}
			}
			System.out.println(a + " " + b);
		}

	}

}