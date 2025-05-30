
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

//groupword
//1316
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine().trim());

		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			Set<Character> set = new HashSet<>();
			char[] st = br.readLine().trim().toCharArray();
			char temp = st[0];
			set.add(temp);

			for (int j = 1; j < st.length; j++) {

				if(st[j] != temp) {
					if(set.contains(st[j])) {
						cnt++;
						break;
					}
					temp = st[j];
					set.add(temp);
				}
			}
		}
		
		System.out.println(n-cnt);
	}
}
