import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String temp = br.readLine().trim();

		int answer = 0;

		Set<String> set = new HashSet();
		set.add("c=");
		set.add("c-");
		set.add("dz=");
		set.add("d-");
		set.add("lj");
		set.add("nj");
		set.add("s=");
		set.add("z=");

		for (int i = 0; i < temp.length(); i++) {
			String first, second;
			if (i + 2 <= temp.length()) {
				first = temp.substring(i, i + 2);
				if (set.contains(first)) {
					answer++;
					i++;
					continue;
				}
			}
			if (i + 3 <= temp.length()) {
				second = temp.substring(i, i + 3);
				if (set.contains(second)) {
					answer++;
					i += 2;
					continue;
				}
			}
			answer++;
		}

		System.out.println(answer);
	}

}
