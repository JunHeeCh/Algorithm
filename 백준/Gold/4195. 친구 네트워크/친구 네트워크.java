
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static Map<String, Integer> map;
	static int[] friends;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {

			map = new HashMap<>();

			int F = Integer.parseInt(br.readLine().trim());

			int idx = 0;
			friends = new int[2 * F];
			int[] count = new int[2 * F];

			for (int i = 0; i < friends.length; i++) {
				friends[i] = i;
				count[i] = 1;
			}

			for (int i = 0; i < F; i++) {
				String[] temp = br.readLine().trim().split(" ");
				String f1 = temp[0];
				String f2 = temp[1];

				if (map.get(f1) == null) {
					map.put(f1, idx++);
				}
				if (map.get(f2) == null) {
					map.put(f2, idx++);
				}

				int a = map.get(f1);
				int b = map.get(f2);

				if(findSet(a) != findSet(b)) {
					count[findSet(a)] += count[findSet(b)];
				}
				union(a, b);
				
				System.out.println(count[findSet(a)]);
			}

		} // tc

	}

	private static void union(int a, int b) {
		friends[findSet(b)] = findSet(a);
	}

	private static int findSet(int i) {
		if (friends[i] != i) {
			friends[i] = findSet(friends[i]);
		}
		return friends[i];
	}
}
