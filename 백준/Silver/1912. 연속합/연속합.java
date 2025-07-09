import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine().trim());
		
		int[] nums = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int max = nums[0];
		int now = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			int a = now+nums[i];
			int b = nums[i];
			
			now = Math.max(a, b);
			max = Math.max(max, now);
		}
		
		
		System.out.println(max);
		
		
	}
}
