import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);

		List<street>[] list = new ArrayList[N + 1];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			String[] abc = br.readLine().trim().split(" ");
			int a = Integer.parseInt(abc[0]);
			int b = Integer.parseInt(abc[1]);
			int c = Integer.parseInt(abc[2]);
			
			list[a].add(new street(b, c));
			list[b].add(new street(a, c));
			
		}

		boolean[] visited = new boolean[N + 1];
		
		int max = 0;
		
		PriorityQueue<street> pQueue = new PriorityQueue<>();
		pQueue.offer(new street(1, 0));
		int pick = 0;
		int total = 0;
		
		while (!pQueue.isEmpty()) {
			street now = pQueue.poll();
			
			if(visited[now.to]) continue;
			
			visited[now.to] = true;
			pick++;
			total += now.cost;
			
			
			if(max<now.cost) {
				max = now.cost;
			}
			
			if(pick==N) {
				break;
			}
			
			for (street next : list[now.to]) {
				if(!visited[next.to]) {
					pQueue.add(next);
				}
			}
			
		}
		
		System.out.println(total-max);

	}
}

class street implements Comparable<street>{
	int to, cost;

	public street(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(street o) {
		return this.cost-o.cost;
	}
	
	
}