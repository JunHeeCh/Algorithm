import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int X = Integer.parseInt(temp[1]);

		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] cnt = new int[N];
		cnt[0] = arr[0];
		for (int i = 1; i < N; i++) {
			cnt[i] = cnt[i-1]+arr[i];
		}
		
		int max = cnt[X-1];
		int count = 1;
		int tmp;
		
		for (int i = X; i < N; i++) {
			tmp = cnt[i]-cnt[i-X];
			if(max < tmp) {
				max = tmp;
				count = 1;
			}else if(max == tmp) {
				count++;
			}
		}
		
		if(max == 0) {
			System.out.println("SAD");
		}else {
			System.out.println(max);
			System.out.println(count);			
		}
		

	}

}

