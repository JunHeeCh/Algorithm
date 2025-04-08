
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		boolean[] visited = new boolean[N + 1];
		int idx = 0;

		int P = 2;
		int res = 2;

		wh: while (idx < K) {
			for (int i = P; i <= N; i += P) {
				if(visited[i]) {
					continue;
				}
				visited[i] = true;
				idx++;
				res = i;
				if (idx == K)
					break wh;
			}
			for (int i = 2; i <= N; i++) {
				if (!visited[i]) {
					P = i;
					continue wh;
				}
			}

		}
		System.out.println(res);

	}
}
