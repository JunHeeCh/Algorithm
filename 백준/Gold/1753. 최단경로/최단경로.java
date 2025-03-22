
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//1753
public class Main {

	static class Node implements Comparable<Node> {
		int my;
		int cost;

		public Node() {
			// TODO Auto-generated constructor stub
		}

		private Node(int my, int cost) {
			this.my = my;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

	static List<List<Node>> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] ve = br.readLine().trim().split(" ");

		int V = Integer.parseInt(ve[0]);
		int E = Integer.parseInt(ve[1]);

		int start = Integer.parseInt(br.readLine());

		for (int i = 0; i < V + 1; i++) {
			List<Node> temp = new ArrayList<>();
			list.add(temp);
		}

		for (int i = 0; i < E; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			Node save = new Node(v, w);

			list.get(u).add(save);

		}
		// 입력 완료

//		boolean[] visited = new boolean[V + 1]; // 해당 노드 방문해서 갱신했는지 확인
		int[] distance = new int[V + 1]; // 시작 노드에서 다른 노드까지의 거리를 저장한 배열

		for (int i = 1; i < V + 1; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[start] = 0;
//		visited[start] = true;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));

		while (!pq.isEmpty()) {
			Node now = pq.poll();

			for (Node node : list.get(now.my)) {
				if (distance[node.my] > distance[now.my] + node.cost) {
					distance[node.my] = distance[now.my] + node.cost;
					pq.offer(new Node(node.my, distance[node.my]));
				}
			}

		}

		// 출력
		for (int i = 1; i < V + 1; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(distance[i]);
			}
		}

	}
}
