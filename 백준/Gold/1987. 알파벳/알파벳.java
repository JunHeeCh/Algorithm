import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Main {

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력
		String[] temp = br.readLine().trim().split(" ");

		int R = Integer.parseInt(temp[0]);
		int C = Integer.parseInt(temp[1]);

		char[][] board = new char[R][C];

		for (int i = 0; i < board.length; i++) {
			char[] tmp = br.readLine().trim().toCharArray();
			for (int j = 0; j < board[0].length; j++) {
				board[i][j] = tmp[j];
			}
		}

		// 로직 (dfs)
		res = 0;
		Set<Character> set = new HashSet<>();
		set.add(board[0][0]);

		dfs(board, 0, 0, set, 1);

		System.out.println(res);
	}

	private static void dfs(char[][] board, int r, int c, Set<Character> set, int time) {
		res = Math.max(res, time);

		for (int i = 0; i < dr.length; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nc < 0 || nr >= board.length || nc >= board[0].length) {
				continue;
			}

			if (!set.contains(board[nr][nc])) {
				set.add(board[nr][nc]);
				dfs(board, nr, nc, set, time + 1);
				set.remove(board[nr][nc]);
			}
		}

	}
}
