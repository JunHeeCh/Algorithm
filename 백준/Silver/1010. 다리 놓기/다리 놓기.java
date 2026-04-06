import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;

		while (T > 0) {
			st = new StringTokenizer(br.readLine().trim());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			long ans = 1;

			for (int i = 0; i < a; i++) {
				ans *= (b - i);
				ans /= (i + 1);
			}

			System.out.println(ans);
			T--;
		}

	}

}
