import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] board = new int[100][100];

		int res = 0;

		StringTokenizer st;
		int N = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			for (int j = a; j < a + 10; j++) {
				for (int k = b; k < b + 10; k++) {
					if (board[j][k] == 1) {
						continue;
					} else {
						board[j][k] = 1;
						res++;
					}
				}
			}
		}

		System.out.println(res);

	}

}
