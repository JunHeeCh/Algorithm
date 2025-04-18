import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] lc = br.readLine().trim().split(" ");
		int N = Integer.parseInt(lc[0]);
		int M = Integer.parseInt(lc[1]);

		Set<String> set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			set.add(br.readLine().trim());
		}
		
		int cnt = 0;
		List<String> result = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			String temp = br.readLine().trim();
			if(set.contains(temp)) {
				cnt++;
				result.add(temp);
			}
		}
		
		result.sort(null);
		System.out.println(cnt);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}

		

	}

	
}
