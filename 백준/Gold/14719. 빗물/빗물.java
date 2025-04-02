import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int result;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int H = Integer.parseInt(temp[0]);
		int W = Integer.parseInt(temp[1]);

		int[] board = new int[W];
		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int max = 0;
		for (int i = 0; i < W; i++) {
			board[i] = Integer.parseInt(st.nextToken());
			if (max < board[i]) {
				max = board[i];
			}
		}
		// 입력 완료

		result = 0;

		visited = new boolean[W];

		for (int i = max; i > 0; i--) {
			check(board, i);
		}

		System.out.println(result);
	}
	private static void check(int[] board, int max) {
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < board.length; i++) {
			if(board[i] >= max) {
				list.add(i);
			}
		}
		
		if(list.size()<2) {
			return;
		}
		
		int s = list.get(0);
		int e = list.get(list.size()-1);
		
		for (int i = s; i <= e; i++) {
			if(!visited[i]) {
				visited[i] = true;
				if(max-board[i] > 0) {
					result += max-board[i];
				}
			}
		}
		
	}
}
