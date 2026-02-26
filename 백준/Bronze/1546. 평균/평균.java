import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		int max = 0;
		float sum = 0;

		String[] temp = br.readLine().trim().split(" ");

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(temp[i]);
			max = Math.max(max, arr[i]);
			sum += arr[i];
		}

		sum = sum * 100 / (max * N);

		System.out.println(sum);

	}

}
