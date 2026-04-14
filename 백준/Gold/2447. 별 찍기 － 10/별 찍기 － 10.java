import java.io.*;
import java.util.*;

public class Main {

	static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int n = Integer.parseInt(br.readLine().trim());

		arr = new char[n][n];

		draw(0, 0, n);

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == '*') {
					sb.append("*");
				} else {
					sb.append(" ");
				}
			}
			sb.append("\n");
		}

		System.out.print(sb);

	}

	private static void draw(int x, int y, int n) {

		if (n == 1) {
			arr[x][y] = '*';
			return;
		}

		int size = n / 3;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i != 1 || j != 1) {
					draw(x + i * size, y + j * size, size);
				}
			}
		}
	}

}
