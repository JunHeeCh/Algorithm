import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int d = Integer.parseInt(temp[1]);
		int k = Integer.parseInt(temp[2]);
		int c = Integer.parseInt(temp[3]);

		int[] num = new int[N];

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine().trim());
		}

		int[] cnt = new int[3001];
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < k; i++) {
			set.add(num[i]);
			cnt[num[i]]++;
		}

		int res = set.size();
		if (!set.contains(c)) {
			res++;
		}

		for (int i = 0; i < N - 1; i++) {
			cnt[num[i]]--;
			if (cnt[num[i]] == 0) {
				set.remove(num[i]);
			}

			int next = (i + k) % N;
			set.add(num[next]);
			cnt[num[next]]++;

			if (!set.contains(c)) {
				res = Math.max(res, set.size() + 1);
			} else {
				res = Math.max(res, set.size());
			}

		}

		System.out.println(res);
	}

}
