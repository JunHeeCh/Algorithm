import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().trim().split(" ");
		
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		
		p = new int[N+1];
		
		for (int i = 0; i < p.length; i++) {
			p[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			String[] tmp = br.readLine().trim().split(" ");
			int a = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[1]);
			
			union(a,b);
		}
		
		for (int i = 1; i < p.length; i++) {
			parents(i);
		}
		
		boolean[] visited = new boolean[N+1];
		int cnt = 0;
		for (int i = 1; i < p.length; i++) {
			if(!visited[p[i]]) {
				visited[p[i]] = true;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static void union(int a, int b) {
		int rootA = parents(a);
	    int rootB = parents(b);
	    
	    if(rootA != rootB) {
	        p[rootB] = rootA; // 또는 p[rootA] = rootB; 둘 중 하나 선택
	    }
	}

	private static int parents(int a) {
		if(p[a] != a) {
			p[a] = parents(p[a]);
		}
		return p[a];
	}
}
