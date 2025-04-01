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
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		PriorityQueue<street> pQueue = new PriorityQueue<>();

		float[][] star = new float[N][2];
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().trim().split(" ");
			star[i][0] = Float.parseFloat(temp[0]); // x좌표
			star[i][1] = Float.parseFloat(temp[1]); // y좌표
		}

		for (int i = 0; i < star.length - 1; i++) {
			for (int j = i + 1; j < star.length; j++) {
//				star[i]랑 star[j]를 연결하는 길 만들어서 추가해주기
				float difX = star[i][0] - star[j][0];
				float dify = star[i][1] - star[j][1];
				double cost = Math.sqrt((difX * difX) + (dify * dify));

				pQueue.offer(new street(i, j, cost));
			}
		}

		p = new int[N];
		for (int i = 0; i < p.length; i++) {
			p[i] = i;
		}

		int pick = 0;
		double cost = 0;
		
		while (!pQueue.isEmpty()) {
			street nowStreet = pQueue.poll();
			int from = nowStreet.from;
			int to = nowStreet.to;
			
			if(findSet(from) == findSet(to)) continue;
			pick++;
			union(from,to);
			cost += nowStreet.cost;
			
			if(pick == N-1) break;
		}

		System.out.printf("%.2f", cost);

	}

	private static void union(int from, int to) {
		p[findSet(to)] = findSet(from);
	}

	private static int findSet(int i) {
		if(p[i]!=i) {
			p[i]= findSet(p[i]); 
		}
		return p[i];
	}
}

class street implements Comparable<street> {
	int from;
	int to;
	double cost;

	public street(int from, int to, double cost) {
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(street o) {
		return Double.compare(this.cost, o.cost);
	}

}