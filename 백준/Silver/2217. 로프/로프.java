import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine().trim());
		}
		// 로직
		Arrays.sort(arr);
		
		int max = 0;
		
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, (N-i)*arr[i]);
		}
		
		
		// 출력

		System.out.println(max);
	}
}