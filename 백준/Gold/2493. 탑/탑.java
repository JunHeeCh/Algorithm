import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine().trim());

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Stack<int[]> stack = new Stack(); // 숫자, index
		int[] ans = new int[n];

		for (int i = 0; i < n; i++) {
			while (!stack.isEmpty() && stack.peek()[0] < arr[i]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				ans[i] = 0;
			} else {
				ans[i] = stack.peek()[1] + 1;
			}
			stack.add(new int[] { arr[i], i });
		}

		for (int i = 0; i < n; i++) {
			System.out.print(ans[i] + " ");
		}
	}

}