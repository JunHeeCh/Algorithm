import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int ans = 1;
		float last = (float) (arr[0]+L-0.5);
		for(int i=1; i<arr.length; i++) {
			if((float)arr[i]+0.5 <= last) {
				continue;
			}
			ans++;
			last = (float) (arr[i]+L-0.5);
		}
		
		System.out.println(ans);
	}

}
