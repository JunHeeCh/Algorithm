import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);

		List<Integer>[] lists = new ArrayList[N + 1];
		for (int i = 1; i < lists.length; i++) {
			lists[i] = new ArrayList<>();
		}

		int[] depth = new int[N + 1];

		for (int i = 0; i < M; i++) {
			String[] tm = br.readLine().trim().split(" ");
//			int len = Integer.parseInt(tm[0]);
			for(int j = 1; j < tm.length-1; j++) {
				int a=Integer.parseInt(tm[j]);
				int b=Integer.parseInt(tm[j+1]);
				lists[a].add(b);
				depth[b]++;
			}
		}
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < depth.length; i++) {
			if(depth[i]==0) {
				queue.add(i);
			}
		}
		
		int pick = 0;
		
		while (!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now+"\n");
//			System.out.print(now+" ");
			pick++;
			
			for (int n : lists[now]) {
				depth[n]--;
				if(depth[n]==0) {
					queue.add(n);
				}
			}
		}
		
		if(pick != N) {
			System.out.println(0);
		}else {
			System.out.println(sb);
		}

	}
}
