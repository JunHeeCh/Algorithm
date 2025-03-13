
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[][] cost = new int[N][3];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine().trim();
			StringTokenizer st = new StringTokenizer(temp);
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 완료 
		
		int[][] sum = new int[N][3];
		sum[0][0] = cost[0][0];
		sum[0][1] = cost[0][1];
		sum[0][2] = cost[0][2];

		for (int i = 1; i < N; i++) {
			sum[i][0] = cost[i][0] + Math.min(sum[i-1][1], sum[i-1][2]);
			sum[i][1] = cost[i][1] + Math.min(sum[i-1][2], sum[i-1][0]);
			sum[i][2] = cost[i][2] + Math.min(sum[i-1][1], sum[i-1][0]);
		}
		
		int res = Math.min(Math.min(sum[N-1][0], sum[N-1][1]), sum[N-1][2]);
		
		System.out.println(res);
		
	}

}
