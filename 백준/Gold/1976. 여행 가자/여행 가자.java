
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());	//도시
		int M = Integer.parseInt(br.readLine().trim());	//여행 도시 수 
		
		parent = new int[N+1];
		
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		
		int conn;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				conn = Integer.parseInt(st.nextToken());
				if(conn==1) {
					union(i+1, j+1);
				}
			}
		}
		
		String[] temp = br.readLine().trim().split(" ");
		
		int root = findSet(Integer.parseInt(temp[0]));
		int check = 0;
		
		for (int i = 1; i < temp.length; i++) {
			check = Integer.parseInt(temp[i]);
			if(findSet(check) != root) {
				check = -10;
				break;
			}
		}
		
		if(check == -10) {
			System.out.println("NO");
		}else {
			System.out.println("YES");
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
