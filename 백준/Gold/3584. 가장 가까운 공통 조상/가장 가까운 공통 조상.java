import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine().trim());
			int[] parent = new int[N + 1];

			for (int j = 0; j < parent.length; j++) {
				parent[j] = j;
			}

			for (int j = 0; j < N - 1; j++) {
				String[] temp = br.readLine().trim().split(" ");
				int a = Integer.parseInt(temp[0]);
				int b = Integer.parseInt(temp[1]);

				parent[b] = a;
			}

			String[] temp = br.readLine().trim().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);

			List<Integer> list1 = new ArrayList<>();
			list1.add(a);
			findP(list1, a, parent);

			List<Integer> list2 = new ArrayList<>();
			list2.add(b);
			findP(list2, b, parent);

			int l1 = list1.size();
			int l2 = list2.size();

			int node = 0;

			for (int j = 1; j <= Math.min(l1, l2); j++) {
				if (!list1.get(l1 - j).equals(list2.get(l2 - j))) {  // equals() 사용
					break;
				}
				node = list1.get(l1 - j);
			}

			System.out.println(node);
		}

	}

	private static void findP(List<Integer> list, int a, int[] parent) {
		if (parent[a] != a) {
			list.add(parent[a]);
			findP(list, parent[a], parent);
		}
		return;
	}

}