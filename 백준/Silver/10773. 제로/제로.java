import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		Stack<Integer> st = new Stack();
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine().trim());
			if (temp == 0) {
				st.pop();
			} else {
				st.add(temp);
			}
		}

		int sum = 0;
		while (!st.isEmpty()) {
			sum += st.pop();
		}

		System.out.println(sum);

	}

}
