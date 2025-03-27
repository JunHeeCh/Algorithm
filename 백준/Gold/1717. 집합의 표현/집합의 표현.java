
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().trim().split(" ");
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);
		
		parent = new int[N+1];
		
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int check = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(check==0) {
				union(a,b);
			}else {
				if(findSet(a) == findSet(b)) {
					System.out.println("yes");
				}else {
					System.out.println("no");
				}
			}
			
		}
		
	}

	private static void union(int a, int b) {
		parent[findSet(b)] = findSet(a);
	}

	private static int findSet(int a) {
		if(parent[a]==a) {
			return a;
		}
		return parent[a] = findSet(parent[a]);
	}
}
