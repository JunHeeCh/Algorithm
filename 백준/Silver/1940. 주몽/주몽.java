import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		int M = Integer.parseInt(br.readLine().trim());

		if (M > 200000) {
			System.out.print(0);
			return;
		}

		String[] temp = br.readLine().trim().split(" ");
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}

		int answer = 0;

		int left = 0;
		int right = N-1;
		
		Arrays.sort(arr);
		
		while(left < right) {
			int sum = arr[left]+arr[right];
			
			if(sum==M) {
				answer++;
				left++;
				right--;
			}else if(sum > M) {
				right--;
			}else {
				left++;
			}
		}

		System.out.println(answer);

	}

}
