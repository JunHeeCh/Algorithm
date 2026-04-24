import java.io.*;
import java.util.*;

public class Main {

	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		char[] temp = br.readLine().trim().toCharArray();

		Stack<Character> stack = new Stack();

		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == '<') {
				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				while (temp[i] != '>') {
					sb.append(temp[i]);
					i++;
				}
				sb.append(">");
				continue;
			} else if (temp[i] == ' ') {

				while (!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(" ");

			} else {
				stack.add(temp[i]);
			}

		}

		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		System.out.print(sb);
	}

}
