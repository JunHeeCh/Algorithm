import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 입력
		int N = Integer.parseInt(br.readLine().trim());

		List<Integer>[] lists = new ArrayList[N+1];

		for (int i = 0; i < lists.length; i++) {
			lists[i] = new ArrayList<>();
		}

		for (int i = 0; i < N-1; i++) {
			String[] temp = br.readLine().trim().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			lists[a].add(b);
			lists[b].add(a);
		}

		// 로직
		int[] parent = new int[N+1];
		findP(lists, parent, 1, 0);

		// 출력
		for (int i = 2; i < parent.length; i++) {
			System.out.println(parent[i]);
		}
	}

	private static void findP(List<Integer>[] lists, int[] parent, int now, int prev) {
		
		for (int next : lists[now]) {
			if(next == prev) continue;
			parent[next] = now;
			findP(lists, parent, next, now);
		}
		
	}

}
