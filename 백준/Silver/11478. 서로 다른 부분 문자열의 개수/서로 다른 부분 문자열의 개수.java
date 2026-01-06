import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static Set<String> set;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] temp = br.readLine().trim().toCharArray();

		set = new HashSet();

		for (int i = 0; i < temp.length; i++) {
			for (int j = 1; j <= temp.length; j++) {
				if (i + j > temp.length)
					break;
				String s = String.copyValueOf(temp, i, j);
				set.add(String.copyValueOf(temp, i, j));
			}
		}

		System.out.println(set.size());
	}

}