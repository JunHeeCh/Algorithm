import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] temp = br.readLine().trim().split(" ");

		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);

		String[] title = new String[N];
		int[] power = new int[N];

		for (int i = 0; i < N; i++) {
			temp = br.readLine().trim().split(" ");
			title[i] = temp[0];
			power[i] = Integer.parseInt(temp[1]);
		}

		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(br.readLine().trim());
			int res = find(power, num);
			sb.append(title[res]+"\n");
		}
		
		System.out.println(sb);

	}

	private static int find(int[] power, int num) {
		int start = 0;
		int end = power.length-1;
		
		while(start < end) {
			int mid = (start+end)/2;
			
			if(power[mid] >= num) {
				end = mid;
			}else {
				start = mid+1;
			}
		}
		
		return start;

	}
}
