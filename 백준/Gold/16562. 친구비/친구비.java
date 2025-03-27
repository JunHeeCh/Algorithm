
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	static int[] P;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nmk = br.readLine().trim().split(" ");
		int N = Integer.parseInt(nmk[0]);	// 학생수
		int M = Integer.parseInt(nmk[1]);	// 친구 관계 수
		int K = Integer.parseInt(nmk[2]);	// 가진 돈
		
		String[] c = br.readLine().trim().split(" ");
		int[] cost = new int[N+1];
		for (int i = 1; i < cost.length; i++) {
			cost[i] = Integer.parseInt(c[i-1]);
		}
		
		P = new int[N+1];
		for (int i = 1; i < P.length; i++) {
			P[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			String[] vw = br.readLine().trim().split(" ");
			int V = Integer.parseInt(vw[0]);
			int W = Integer.parseInt(vw[1]);
			
			union(V,W);
		}
		

		
		int sum = 0;

		
		int[] minCost = new int[N+1];
		for (int i = 1; i < P.length; i++) {
			int group = findSet(i);
			if(minCost[group]==0) {
				minCost[group] = cost[i];
			}else if(minCost[group]>0) {
				if(minCost[group] > cost[i]) {
					minCost[group] = cost[i];
				}
			}
		}
		
		for (int i = 0; i < minCost.length; i++) {
			sum += minCost[i];
		}
		
		if(sum <= K) {
			System.out.println(sum);
		}else {
			System.out.println("Oh no");
		}
		
	}

	private static void union(int v, int w) {
		P[findSet(w)] = findSet(v);
	}

	private static int findSet(int v) {
		if(P[v]==v) return v;

		return P[v] = findSet(P[v]);
	}
}
