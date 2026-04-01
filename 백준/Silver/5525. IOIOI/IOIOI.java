import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine().trim());
		int m = Integer.parseInt(br.readLine().trim());

		String s = br.readLine().trim();

		int count = 0;
		int ans = 0;

		for (int i = 0; i < m - 2; i++) {
			if (s.charAt(i) == 'I' && s.charAt(i + 1) == 'O' && s.charAt(i + 2) == 'I') {
				count++;
				i++;

				if (count >= n) {
					ans++;
				}
			} else {
				count = 0;
			}
		}

		System.out.println(ans);

	}

}
