import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] S = br.readLine().trim().toCharArray();
		char[] T = br.readLine().trim().toCharArray();

		List<Character> s = new ArrayList();
		List<Character> t = new ArrayList();

		for (int i = 0; i < S.length; i++) {
			s.add(S[i]);
		}
		for (int i = 0; i < T.length; i++) {
			t.add(T[i]);
		}

		while (s.size() != t.size()) {
			if (t.get(t.size() - 1) == 'A') { // getLast() 대신
				t.remove(t.size() - 1); // removeLast() 대신
			} else {
				t.remove(t.size() - 1); // removeLast() 대신
				Collections.reverse(t); // reversed() 대신
			}
		}

		for (int i = 0; i < t.size(); i++) {
			if (t.get(i) != s.get(i)) {
				System.out.println(0);
				return;
			}
		}

		System.out.println(1);
	}

}
