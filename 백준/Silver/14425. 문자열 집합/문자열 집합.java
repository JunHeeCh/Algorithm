import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");

		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		
		Set<String> set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			set.add(br.readLine().trim());
		}
		
		int res = 0;
		
		for (int i = 0; i < M; i++) {
			String tmp = br.readLine().trim();
			if(set.contains(tmp)) {
				res++;
			}
		}
		
		System.out.println(res);
		
		

	}
}
