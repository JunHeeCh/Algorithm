import java.io.*;
import java.util.*;

public class Main {

	static int INF = 1000000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);

		int[][] res = new int[N + 1][N + 1];

		int[][] weight = new int[N + 1][N + 1];
		for (int i = 0; i < weight.length; i++) {
			Arrays.fill(weight[i], INF);
			Arrays.fill(res[i], INF);
		}

		for (int i = 0; i < weight.length; i++) {
			weight[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			temp = br.readLine().trim().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			int c = Integer.parseInt(temp[2]);

			weight[a][b] = c;
			weight[b][a] = c;
			res[a][b] = b;
			res[b][a] = a;
		}

		for (int k = 1; k < weight.length; k++) {
			for (int i = 1; i < weight.length; i++) {
				for (int j = 1; j < weight.length; j++) {
					if (i == j || weight[i][k] == INF || weight[k][j] == INF)
						continue;
					if (weight[i][k] + weight[k][j] < weight[i][j]) {
						weight[i][j] = weight[i][k] + weight[k][j];
						res[i][j] = res[i][k];
					}
				}
			}
		}

		for (int i = 1; i < res.length; i++) {
			for (int j = 1; j < res[0].length; j++) {
				if (i == j) {
					System.out.print("- ");
				} else {
					System.out.print(res[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

}
