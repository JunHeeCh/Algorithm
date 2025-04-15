
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] num;
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		num = new int[N];
		p = new int[N];

		for (int i = 0; i < p.length; i++) {
			p[i] = i;
		}

		String[] temp = br.readLine().trim().split("");
		for (int i = 0; i < temp.length; i++) {
			if (temp[i].equals("E")) {
				num[i] = 1;
			}else {
				num[i] = -1;
			}
		}
		
		//입력 완료 
		
		for (int i = 0; i < num.length; i++) {
			if(num[i]==1) {
				union(i, i+1);
			}else {
				if(i==0) continue;
				union(i-1, i);
			}
		}
		
		boolean[] visited = new boolean[N];
		int res = 0;
		for (int i = 0; i < p.length; i++) {
			if(!visited[p[i]]) {
				res++;
				visited[p[i]] = true;
			}
		}
		
		System.out.println(res);

	}

	private static void union(int i, int j) {
		p[findp(j)] = findp(i);
	}

	private static int findp(int i) {
		if(p[i] != i) {
			p[i] = findp(p[i]);
		}
		return p[i];
	}
}
