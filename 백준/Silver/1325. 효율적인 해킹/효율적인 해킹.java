import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));

		String[] temp = br.readLine().trim().split(" ");
		
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);

		boolean[] visited = new boolean[N + 1];
		List<Integer>[] list = new ArrayList[N + 1];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			String[] tmp = br.readLine().trim().split(" ");
			
			int a = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[1]);

			list[b].add(a);
		}

		int[] total = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			// 각각의 번호로 bfs 실시
			bfs(total, list, i);
		}

		int max = 0;
		for (int i = 1; i < total.length; i++) {
			max = Math.max(max, total[i]);
		}

		for (int i = 1; i < total.length; i++) {
			if (total[i] == max) {
				System.out.print(i + " ");
			}
		}

	}

	private static void bfs(int[] total, List<Integer>[] list, int start) {

		Queue<Integer> queue = new LinkedList();
		boolean[] visited = new boolean[total.length];

		queue.add(start);
		visited[start] = true;
		int count = 1;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int i : list[now]) {
				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
					count++;
				}
			}
		}

		total[start] = count;

	}
}
