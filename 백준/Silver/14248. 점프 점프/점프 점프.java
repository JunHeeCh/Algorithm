import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x = Integer.parseInt(br.readLine().trim());

		String[] temp = br.readLine().trim().split(" ");
		int[] arr = new int[x + 1];
		for (int i = 1; i <= temp.length; i++) {
			arr[i] = Integer.parseInt(temp[i - 1]);
		}

		int s = Integer.parseInt(br.readLine().trim());

		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[x + 1];

		queue.add(s);
		visited[s] = true;

		int res = 1;
		
		while (!queue.isEmpty()) {
			int now = queue.poll();

			int a = now - arr[now];
			int b = now + arr[now];
			
			if(a >= 1 && a <= x && !visited[a]) {
				visited[a] = true;
				res++;
				queue.add(a);
			}
			
			if(b >= 1 && b <= x && !visited[b]) {
				visited[b] = true;
				res++;
				queue.add(b);
			}
		}

		System.out.println(res);

	}

}
