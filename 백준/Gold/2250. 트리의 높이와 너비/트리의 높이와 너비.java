import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int num = 1;
	static int[] depth;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int N = Integer.parseInt(br.readLine().trim());

		int[][] nodes = new int[N + 1][2];

		boolean[] hasP = new boolean[N + 1];
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().trim().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			int c = Integer.parseInt(temp[2]);

			nodes[a][0] = b;
			nodes[a][1] = c;

			if (b != -1) hasP[b] = true;
            if (c != -1) hasP[c] = true;
		}
		
		int root = 0;
		for (int i = 1; i < hasP.length; i++) {
			if(!hasP[i]) {
				root = i;
				break;
			}
		}

		// 로직
		depth = new int[N + 1];
		depth[root] = 1;

		findDepth(nodes, root);

		int maxD = 0;
		for (int i = 1; i < depth.length; i++) {
			maxD = Math.max(maxD, depth[i]);
		}

		int[][] board = new int[maxD + 1][N + 1];

		inOrder(board, nodes, root);

		int resLevel = 0, resDepth = 0;

		for (int i = 1; i < board.length; i++) {
			int left = -1, right = -1;
			for (int j = 1; j < board[0].length; j++) {
				if (board[i][j] > 0) {
					if (left == -1) {
						left = j;
					}
					right = j;
				}
			}

			if (resDepth < right - left + 1) {
				resDepth = right - left + 1;
				resLevel = i;
			}
		}

		// 출력
		System.out.println(resLevel + " " + resDepth);
	}

	private static void inOrder(int[][] board, int[][] nodes, int i) {
		if (nodes[i][0] != -1) {
			inOrder(board, nodes, nodes[i][0]);
		}
		board[depth[i]][num++] = i;
		if (nodes[i][1] != -1) {
			inOrder(board, nodes, nodes[i][1]);
		}

	}

	private static void findDepth(int[][] nodes, int i) {

		for (int j = 0; j <= 1; j++) {
			if (nodes[i][j] != -1) {
				depth[nodes[i][j]] = depth[i] + 1;
				findDepth(nodes, nodes[i][j]);
			}
		}

	}

}
