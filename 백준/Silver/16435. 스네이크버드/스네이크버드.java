import java.util.*;
import java.io.*;

public class Main {
	static int saved;
	static int curr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		int[] h = new int[n];
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < n; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(h);

		for (int i = 0; i < h.length; i++) {
			if (l >= h[i]) {
				l++;
			} else {
				break;
			}
		}

		System.out.println(l);
	}

}
