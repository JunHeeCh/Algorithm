import java.io.*;
import java.util.*;

public class Main {

	static int max;
	static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine().trim());

		String[] temp = br.readLine().trim().split(" ");

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}

		temp = br.readLine().trim().split(" ");

		int plus = Integer.parseInt(temp[0]);
		int minus = Integer.parseInt(temp[1]);
		int multiply = Integer.parseInt(temp[2]);
		int devide = Integer.parseInt(temp[3]);

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		cal(arr, plus, minus, multiply, devide, 1, arr[0]);

		System.out.println(max);
		System.out.print(min);

	}

	private static void cal(int[] arr, int plus, int minus, int multiply, int devide, int idx, int num) {
		if (idx >= arr.length) {
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}

		if (plus > 0) {
			cal(arr, plus - 1, minus, multiply, devide, idx + 1, num + arr[idx]);
		}
		if (minus > 0) {
			cal(arr, plus, minus - 1, multiply, devide, idx + 1, num - arr[idx]);
		}
		if (multiply > 0) {
			cal(arr, plus, minus, multiply - 1, devide, idx + 1, num * arr[idx]);
		}
		if (devide > 0) {
			cal(arr, plus, minus, multiply, devide - 1, idx + 1, devide(num, arr[idx]));
		}
		return;
	}

	private static int devide(int a, int b) {
		if (a > 0)
			return a / b;
		return -((-1 * a) / b);
	}

}
