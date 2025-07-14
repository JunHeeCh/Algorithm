import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < tc; i++) {
			int n = Integer.parseInt(br.readLine().trim());

			String[] arr = new String[n];

			for (int j = 0; j < n; j++) {
				arr[j] = br.readLine().trim();
			}

			Arrays.sort(arr);

			// 작은 수부터 확인하기

			boolean flag = false;

			for (int j = 0; j < arr.length-1; j++) {
				if (arr[j+1].startsWith(arr[j])) {
					flag = true;
					break;
				}
			}

			if (flag) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}

		}

	}

}
