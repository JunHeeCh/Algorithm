import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int T = Integer.parseInt(st.nextToken());

		List<Integer> minus = new ArrayList();
		List<Integer> plus = new ArrayList();
		int one = 0, zero = 0;

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			int num = Integer.parseInt(st.nextToken());
			if (num < 0) {
				minus.add(num);
			} else if (num == 1) {
				one++;
			} else if (num > 1) {
				plus.add(num);
			} else if (num == 0) {
				zero++;
			}
		}

		minus.sort(null);
		plus.sort(Comparator.reverseOrder());

		int ans = one;

		while (minus.size() > 1) {
			ans += minus.get(0) * minus.get(1);
			minus.remove(0);
			minus.remove(0);
		}

		if (!minus.isEmpty()) {
			if (zero == 0) {
				ans += minus.get(0);
			}
		}

		while (!plus.isEmpty()) {
			if (plus.size() > 1) {
				ans += plus.get(0) * plus.get(1);
				plus.remove(0);
				plus.remove(0);
			} else {
				ans += plus.get(0);
				plus.remove(0);
			}
		}

		System.out.print(ans);
	}

}
