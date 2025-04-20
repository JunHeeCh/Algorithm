
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		Set<String> set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			set.add(br.readLine().trim());
		}

		int M = Integer.parseInt(br.readLine().trim());

		int res = 0;
		for (int i = 0; i < M; i++) {
			String check = br.readLine().trim();
			if(set.contains(check)) {
				res++;
			}
		}
		
		System.out.println(res);

	}
}
