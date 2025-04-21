
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().trim().split(" ");
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);

		int[] nums = new int[N];
		String[] temp = br.readLine().trim().split(" ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(temp[i]);
		}
		
		for (int i = 1; i < nums.length; i++) {
			nums[i] += nums[i-1];
		}

		int total;

		for (int i = 0; i < M; i++) {
			String[] ij = br.readLine().trim().split(" ");
			int s = Integer.parseInt(ij[0]);
			int e = Integer.parseInt(ij[1]);

			if(s==1) {
				total = nums[e-1];
			}else {
				total = nums[e-1] - nums[s-2];
			}
			
			System.out.println(total);
		}

	}
}
