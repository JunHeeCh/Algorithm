import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		long sum = 0;
		long xor = 0;

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if (a == 1) {
				long b = Long.parseLong(st.nextToken());
				sum += b;
				xor ^= b;
			} else if (a == 2) {
				long b = Long.parseLong(st.nextToken());
				sum -= b;
				xor ^= b;
			} else if (a == 3) {
				System.out.println(sum);
			} else {
				System.out.println(xor);
			}
		}

	}

}
