import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long res = 0;
	static int[] copy;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		copy = new int[N];
		
		int[] arr = new int[N];

		String[] temp = br.readLine().trim().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}

		mergeSort(arr, 0, N - 1);

		System.out.print(res);

	}

	private static void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);
		}

	}

	private static void merge(int[] arr, int start, int mid, int end) {

		int s1 = start;
		int s2 = mid + 1;

		int idx = start;

		while (s1 <= mid && s2 <= end) {
			if (arr[s1] <= arr[s2]) {
				copy[idx++] = arr[s1++];
			} else {
				copy[idx++] = arr[s2++];
				res += mid + 1 - s1;
			}
		}

		if (s1 <= mid) {
			for (int i = s1; i <= mid; i++) {
				copy[idx++] = arr[i];
			}
		} else {
			for (int i = s2; i <= end; i++) {
				copy[idx++] = arr[i];
			}
		}

		for (int i = start; i <= end; i++) {
			arr[i] = copy[i];
		}

	}

}
