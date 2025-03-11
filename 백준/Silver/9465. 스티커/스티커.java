import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] memo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sBuilder = new StringBuilder();

		int T = Integer.parseInt(bReader.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(bReader.readLine().trim());
			int[][] sticker = new int[2][N];
			String temp = bReader.readLine().trim();
			String temp2 = bReader.readLine().trim();
			StringTokenizer st = new StringTokenizer(temp + " " + temp2);
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < N; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// 입력 완료
			memo = new int[2][N];
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < N; j++) {
					memo[i][j] = -1;
				}
			}
			int res = dp(sticker, 0, 0);
			res = Math.max(res, dp(sticker, 1, 0));
			sBuilder.append(res + "\n");

		} // tc
		System.out.println(sBuilder);
	}

	private static int dp(int[][] sticker, int r, int c) {
		if (c == N - 1) {
			return sticker[r][c];
		}else if(c==N-2) {
			return sticker[r][c]+sticker[1-r][c+1];
		}

		if (memo[r][c] == -1) {
			memo[r][c] = Math.max(dp(sticker, 1-r, c+1), dp(sticker, 1-r, c+2)) + sticker[r][c];
		}

		return memo[r][c];
	}

}
