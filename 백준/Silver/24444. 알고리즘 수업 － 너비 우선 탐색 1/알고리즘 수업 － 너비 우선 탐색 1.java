import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int N = Integer.parseInt(st.nextToken()); // 정점의 수
		int M = Integer.parseInt(st.nextToken()); // 간선의 수
		int R = Integer.parseInt(st.nextToken()); // 시작 정점 

		List<Integer>[] list = new ArrayList[N+1];
		
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list[a].add(b);
			list[b].add(a);
		}
		
		for (int i = 1; i < list.length; i++) {
			list[i].sort(null);
		}

		boolean[] visited= new boolean[N+1];
		Queue<Integer> queue = new LinkedList();
		
		queue.add(R);
		visited[R] = true;
		
		int[] order = new int[N+1];
		int time = 1;
		order[R] = time++;
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			
			for (Integer idx : list[now]) {
				if(!visited[idx]) {
					queue.add(idx);
					visited[idx] = true;
					order[idx] = time++;
				}
			}
			
		}
		
		for (int i = 1; i < order.length; i++) {
			sb.append(order[i]+"\n");
		}
		
		System.out.println(sb);

	}

}
