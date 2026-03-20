import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];
		for (int i = 0; i < N; i++) {
			arr[i + 1] = Integer.parseInt(br.readLine().trim(), 2);
		}

		st = new StringTokenizer(br.readLine().trim());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		List<Integer>[] list = new ArrayList[N+1];
		
		for (int i = 1; i < list.length; i++) {
			list[i] = new ArrayList();
		}
		
		for (int i = 1; i <= N; i++) {
		    for (int j = i + 1; j <= N; j++) {
		        if (Integer.bitCount(arr[i] ^ arr[j]) == 1) {
		            list[i].add(j);
		            list[j].add(i);
		        }
		    }
		}
		
		Queue<Integer> q = new LinkedList();
		boolean[] visited = new boolean[N+1];
		int[] parent = new int[N+1];
		
		q.add(start);
		visited[start] = true;
		parent[start] = -1;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now==end) break;
			
			for(int i : list[now]) {
				if(visited[i]) continue;
				visited[i] = true;
				parent[i] = now;
				q.add(i);
			}
		}
		
		if(!visited[end]) {
			System.out.println("-1");
			return;
		}
		List<Integer> answer = new ArrayList();
		for(int i=end; i != -1; i = parent[i]) {
			answer.add(i);
		}
		
		for(int i=answer.size()-1; i>=0; i--) {
			System.out.print(answer.get(i)+" ");
		}

	}

}
