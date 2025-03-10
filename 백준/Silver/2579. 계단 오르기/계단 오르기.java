import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static int res;
	static Map<Integer, Integer> map = new HashMap<>(); // key는 값, value는 최대 값

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim()); // 계단의 수
		int[] stair = new int[N];
		for (int i = 0; i < stair.length; i++) {
			stair[i] = Integer.parseInt(br.readLine().trim());
		}

		res = 0;
//		dfs(stair, N - 1, stair[N - 1], 0);
		map.put(0, stair[0]);
		int result = dp(stair, N-1);
		System.out.println(result);
	}

	private static Integer dp(int[] stair, int length) {
		if(length<0) return 0;
		
		if(!map.containsKey(length)) {
			map.put(length, Math.max(stair[length-1]+dp(stair, length-3), dp(stair, length-2))+stair[length]);
		}

		return map.get(length);
		
	}

	// cnt로 연속되는지 확인
//	private static void dfs(int[] stair, int depth, int total, int cnt) {
//
//		if (depth == 0) {
//			if (res < total)
//				res = total;
//			return;
//		}
////		if (cnt == 2) {
////			return;
////		}
//
//		if (depth - 1 >= 0 && cnt != 2) {
//
//			dfs(stair, depth - 1, total + stair[depth - 1], cnt + 1);
//		}
//		if (depth - 2 >= 0 && cnt != 2) {
//			dfs(stair, depth - 2, total + stair[depth - 2], 0);
//		}
//
//	}
}
