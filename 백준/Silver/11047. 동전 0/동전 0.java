import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().trim().split(" ");

		int N = Integer.parseInt(temp[0]);
		int K = Integer.parseInt(temp[1]);

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
		}

		int cnt = 0;

		for (int i = N - 1; i >= 0; i--) {
			if (K == 0)
				break;
			int tmp = K / arr[i];
			if (tmp > 0) {
				cnt += tmp;
				K -= arr[i] * tmp;
			}
		}

		System.out.println(cnt);

	}

}
