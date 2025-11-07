import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(br.readLine().trim());

		int min = Math.abs(a - b);
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine().trim());
			if (Math.abs(b - temp) < min) {
				min = Math.abs(b - temp);
				a = temp;
				cnt = 1;
			}
		}

		cnt += Math.abs(a - b);

		System.out.println(cnt);

	}

}
