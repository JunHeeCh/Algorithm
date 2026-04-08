import java.io.*;
import java.util.*;

// 16988
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int N = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			if (x1 == x2 && y1 == y2) {
				if (r1 == r2) {
					System.out.println("-1");
					continue;
				} else {
					System.out.println("0");
					continue;
				}
			}

			double dist = Math.sqrt(Math.abs(x1 - x2) * Math.abs(x1 - x2) + Math.abs(y1 - y2) * Math.abs(y1 - y2));
			if (dist > r1 + r2) {
				System.out.println("0");
			} else if (dist == r1 + r2) {
				System.out.println("1");
			} else if (dist < Math.abs(r1 - r2)) {
				System.out.println("0"); // 내부 포함
			} else if (dist == Math.abs(r1 - r2)) {
				System.out.println("1"); // 내접
			} else {
				System.out.println("2"); // 두 점에서 만남
			}
		}

	}

}
