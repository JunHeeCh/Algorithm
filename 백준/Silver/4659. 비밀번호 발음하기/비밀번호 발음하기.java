import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String temp = br.readLine().trim();

		Set<Character> set = new HashSet();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');

		while (!temp.equals("end")) {
			char[] word = temp.toCharArray();
			boolean flag = true;

			int mo = 0;
			int ja = 0;
			char prev = 0;

			int check = 0;
			for (int i = 0; i < word.length; i++) {
				if (set.contains(word[i])) {
					check++;
					break;
				}
			}
			if (check == 0) {
				sb.append("<" + temp + "> is not acceptable.\n");
				temp = br.readLine().trim();
				continue;
			}

			for (int i = 0; i < word.length; i++) {
				if (set.contains(word[i])) {
					mo++;
					ja = 0;
				} else {
					ja++;
					mo = 0;
				}

				if (mo == 3 || ja == 3) {
					flag = false;
					break;
				}

				if (word[i] == prev) {
					if(prev != 'e' && prev != 'o') {
						flag = false;
						break;						
					}
				}
				prev = word[i];
			}

			if (!flag) {
				sb.append("<" + temp + "> is not acceptable.\n");
			} else {
				sb.append("<" + temp + "> is acceptable.\n");
			}
			temp = br.readLine().trim();
		}

		System.out.print(sb);

	}
}
