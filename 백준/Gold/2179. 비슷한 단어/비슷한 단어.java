import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		String[] arr = new String[N];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = br.readLine().trim();
		}

		String front = null, back = null;
		int max = -1;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i == j)
					continue;
				if (arr[i].equals(arr[j]))
					continue;

				int min = Math.min(arr[i].length(), arr[j].length());
				boolean flag = false;

				for (int k = 0; k < min; k++) {
					if (arr[i].charAt(k) != arr[j].charAt(k)) {
						if (max < k) {
							front = arr[i];
							back = arr[j];
							max = k;
						}
						flag = true;
						break;
					}
				}

				if (!flag) {
					if (max < min) {
						front = arr[i];
						back = arr[j];
						max = min;
					}
				}

			}
		}

		System.out.println(front);
		System.out.println(back);

	}

}
