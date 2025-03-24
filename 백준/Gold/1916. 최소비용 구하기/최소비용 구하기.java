import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//1916
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim()); // 도시 개수
		int M = Integer.parseInt(br.readLine().trim()); // 노선 개수

		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		List<List<Node>> list = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list.get(s).add(new Node(e, w));
		}
		
		String[] temp = br.readLine().trim().split(" ");
		int S = Integer.parseInt(temp[0]);
		int E = Integer.parseInt(temp[1]);
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		
		queue.offer(new Node(S, 0));
		
		distance[S] = 0;
		
		while (!queue.isEmpty()) {
			Node pick = queue.poll();
			
			if(distance[pick.my] < pick.weight) continue;
			
			for (Node n : list.get(pick.my)) {
				
				if(distance[pick.my]+n.weight < distance[n.my]) {
					distance[n.my] = distance[pick.my]+n.weight;
					queue.offer(new Node(n.my, distance[n.my]));
				}
//				else {
//					queue.offer(n);
//				}
				
				
			}
			
		}
		
		System.out.println(distance[E]);
	}
}

class Node implements Comparable<Node>{
	int my;
	int weight;
	
	public Node(int my, int weight) {
		this.my = my;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		
		return Integer.compare(this.weight, o.weight);
	}

	
}