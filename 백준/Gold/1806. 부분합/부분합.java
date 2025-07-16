import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int S = Integer.parseInt(temp[1]);

		int[] num = new int[N];

		temp = br.readLine().trim().split(" ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(temp[i]);
		}

		int start = 0;
		int end =0;
		int sum = 0;
		int min_len = Integer.MAX_VALUE;
		

		while(end < N) {
			sum += num[end];
			end++;
			
			while(sum >= S) {
				min_len = Math.min(min_len, end-start);
				sum -= num[start];
				start++;
			}
		}
		
		if(min_len ==Integer.MAX_VALUE) {
			System.out.print(0);
		}else {
			System.out.print(min_len);
		}

	}

}
