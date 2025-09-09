import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine().trim());

		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[i] == 1) {
				list.add(i);
			}
		}
		
		if(list.size() < K) {
			System.out.println(-1);
			return;
		}

		int last = list.size() - 1;

		int start = 0;
		int end = K - 1;

		int res = Integer.MAX_VALUE;

		while (end <= last) {
			res = Math.min(res, list.get(end)-list.get(start)+1);
			start++;
			end++;
		}

		System.out.println(res);

	}

}
