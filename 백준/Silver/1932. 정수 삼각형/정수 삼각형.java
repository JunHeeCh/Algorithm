import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int[][] memo;
	static Map<int[], Integer> map = new HashMap<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		int[][] triangle = new int[N][];
		memo = new int[N][];
		for (int i = 0; i < triangle.length; i++) {
			String temp = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(temp);
			int idx = 0;
			triangle[i] = new int[i+1];
			memo[i] = new int[i+1];
			while (st.hasMoreTokens()) {
				memo[i][idx] = -1;
				triangle[i][idx++] = Integer.parseInt(st.nextToken());
			}
		}
		
		int res = dp(triangle, 0,0);
		System.out.println(res);
		
	}
	
	private static int dp(int[][] triangle, int depth, int idx) {
		if(depth == triangle.length-1) {
			return triangle[depth][idx];
		}
		int[] temp = {depth,idx};
		if(memo[depth][idx] == -1) {
			memo[depth][idx] = Math.max(dp(triangle, depth+1, idx), dp(triangle, depth+1, idx+1))+triangle[depth][idx];
		}
//		if(!map.containsKey(temp)) {
//			map.put(temp, Math.max(dp(triangle, depth+1, idx), dp(triangle, depth+1, idx+1))+triangle[depth][idx]);
//		}

//		return map.get(temp);
		return memo[depth][idx];
	}
}
