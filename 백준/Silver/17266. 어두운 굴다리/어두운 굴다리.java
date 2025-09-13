import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();

		StringTokenizer st = new StringTokenizer(sc.nextLine());

		int prev = 0;
		int res = 0;

		for (int i = 0; i < M; i++) {
			int now = Integer.parseInt(st.nextToken());
			if (i == 0) {
				res = Math.max(res, now - prev);
				prev = now;
				continue;
			}

			res = Math.max(res, (int) Math.ceil((double) (now - prev) / 2));
			prev = now;
		}
		
		res = Math.max(res, N-prev);
		
		System.out.println(res);

	}

}