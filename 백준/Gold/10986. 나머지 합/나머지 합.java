import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);

		temp = br.readLine().trim().split(" ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}

		arr[0] = arr[0] % M;
		for (int i = 1; i < N; i++) {
			arr[i] += arr[i - 1];
			arr[i] = arr[i] % M;
		}

		int[] count = new int[M];

		for (int i = 0; i < N; i++) {
			count[arr[i]]++;
		}

		long answer = count[0];

		for (int i = 0; i < M; i++) {
			if (count[i] > 0) {
				answer += (long)count[i] * (count[i] - 1) / 2;
			}
		}

		System.out.println(answer);

	}

}
