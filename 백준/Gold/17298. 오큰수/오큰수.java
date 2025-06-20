import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine().trim());

		String[] temp = br.readLine().trim().split(" ");

		int[] arr = new int[N];
		int[] res = new int[N];

		// 입력
		for (int i = 0; i < temp.length; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}

		// 로직
		Stack<Integer> stack = new Stack<>();
		stack.add(0);

		for (int i = 1; i < arr.length; i++) {
			while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
				res[stack.pop()] = arr[i];
			}
			stack.add(i);
		}

		while (!stack.isEmpty()) {
			res[stack.pop()] = -1;
		}

		// 출력
		for (int i = 0; i < res.length; i++) {
			sb.append(res[i] + " ");
		}

		System.out.println(sb);
	}
}
