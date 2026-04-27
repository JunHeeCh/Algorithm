import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == 0 && b == 0 && c == 0)
				break;

			sb.append(find(a, b, c)).append("\n");
		}

		System.out.print(sb);
	}

	static String find(int a, int b, int c) {

		if (b - a == c - b) {
			return "AP " + (c + b - a);
		}

		return "GP " + c * (b / a);
	}
}