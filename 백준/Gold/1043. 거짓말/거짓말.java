import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] temp = br.readLine().trim().split(" ");

		Set<Integer> set = new HashSet<>();

		for (int i = 1; i < temp.length; i++) {
			set.add(Integer.parseInt(temp[i]));
		}

		List<Integer>[] list = new ArrayList[M];
		boolean[] truth = new boolean[M];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < list.length; i++) {
			temp = br.readLine().trim().split(" ");
			for (int j = 1; j < temp.length; j++) {
				int tmp = Integer.parseInt(temp[j]);
				list[i].add(tmp);
				if (set.contains(tmp)) {
					truth[i] = true;
				}
			}
		}

		for (int i = 0; i < truth.length; i++) {
			if (truth[i]) {
				for (Integer num : list[i]) {
					set.add(num);
				}
			}
		}

		boolean change = true;

		while (change) {
			change = false;

			for (int i = 0; i < list.length; i++) {
				if (!truth[i]) {
					for (Integer num : list[i]) {
						if (set.contains(num)) {
							truth[i] = true;

							for (Integer number : list[i]) {
								set.add(number);
							}

							change = true;
							break;
						}
					}
				}
			}

		}

		int res = 0;

		for (int i = 0; i < truth.length; i++) {
			if (!truth[i]) {
				res++;
			}
		}

		System.out.println(res);
	}

}
