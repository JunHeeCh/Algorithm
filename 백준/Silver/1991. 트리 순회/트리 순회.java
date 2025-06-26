import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int N = Integer.parseInt(br.readLine().trim());
		
		int[][] board = new int[N][2];
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().trim().toCharArray();
			int idx = temp[0]-'A';
			board[idx][0] = temp[2]-'A';
			board[idx][1] = temp[4]-'A';
		}

		// 로직

		preOrder(board, 0);
		sb.append("\n");
		inOrder(board, 0);
		sb.append("\n");
		postOrder(board, 0);
		
		
		// 출력
		System.out.println(sb);
	}
	private static void preOrder(int[][] board, int idx) {
		if(idx < 0) return;
		sb.append((char)(idx+'A'));
		preOrder(board, board[idx][0]);
		preOrder(board, board[idx][1]);
	}
	private static void inOrder(int[][] board, int idx) {
		if(idx < 0) return;
		inOrder(board, board[idx][0]);
		sb.append((char)(idx+'A'));
		inOrder(board, board[idx][1]);
	}
	private static void postOrder(int[][] board, int idx) {
		if(idx < 0) return;
		postOrder(board, board[idx][0]);
		postOrder(board, board[idx][1]);
		sb.append((char)(idx+'A'));
	}
	

}
