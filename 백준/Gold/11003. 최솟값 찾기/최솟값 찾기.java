import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int L = Integer.parseInt(temp[1]);

		temp = br.readLine().trim().split(" ");

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}

		Deque<int[]> deque = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			while (!deque.isEmpty() && i - deque.peek()[1] >= L) {
				deque.poll();
			}
			while (!deque.isEmpty() && deque.peekLast()[0] > arr[i]) {
				deque.pollLast();
			}
			deque.add(new int[] { arr[i], i });

			sb.append(deque.peek()[0] + " ");
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.flush();
	}

}
