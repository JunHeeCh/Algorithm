import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int[] num = new int[5];
			
			for(int j = 0; j < 5; j++) {
				num[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(num);
			
			if(num[3]-num[1] >= 4) {
				System.out.println("KIN");
				continue;
			}
			
			int sum = 0;
			for (int j = 1; j < num.length-1; j++) {
				sum += num[j];
			}
			System.out.println(sum);
			
		}
		
	}
}
