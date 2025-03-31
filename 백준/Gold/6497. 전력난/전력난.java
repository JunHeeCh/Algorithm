
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String[] mn = br.readLine().trim().split(" ");
			int N = Integer.parseInt(mn[0]);
			int M = Integer.parseInt(mn[1]);
			
			if(N==0 && M==0) break;
			
			int total = 0;
			PriorityQueue<elec> pq = new PriorityQueue<>();
			
			for (int i = 0; i < M; i++) {
				String[] temp = br.readLine().trim().split(" ");
				int x = Integer.parseInt(temp[0]);
				int y = Integer.parseInt(temp[1]);
				int z = Integer.parseInt(temp[2]);
				
				total+= z;
				
				pq.offer(new elec(x, y, z));
			}
			
			parent = new int[N];
			
			for (int i = 0; i < parent.length; i++) {
				parent[i]=i;
			}
			
			int pick = 0;
			int cost = 0;
			
			while (pick < N-1) {
				elec now = pq.poll();
				int a = now.a;
				int b = now.b;
				
				if(findSet(a) != findSet(b)) {
					pick++;
					cost+= now.cost;
					union(a,b);
				}
			}
			
			System.out.println(total-cost);
		}

		
	}

	private static void union(int a, int b) {
		parent[findSet(b)] = findSet(a);
	}

	private static int findSet(int a) {
		if(parent[a]!= a) {
			parent[a] = findSet(parent[a]);
		}
		return parent[a];
	}
}

class elec implements Comparable<elec>{
	int a,b,cost;

	elec(int a, int b, int cost) {
		this.a = a;
		this.b = b;
		this.cost = cost;
	}

	@Override
	public int compareTo(elec o) {
		return this.cost-o.cost;
	}
	
	
}
