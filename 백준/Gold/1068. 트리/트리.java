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
		// 입력
		int N = Integer.parseInt(br.readLine().trim());

		List<Integer>[] child = new ArrayList[N];

		for (int i = 0; i < child.length; i++) {
			child[i] = new ArrayList<>();
		}

		int[] parent = new int[N];
	
		String[] temp = br.readLine().trim().split(" ");
		for (int i = 0; i < parent.length; i++) {
			parent[i] = Integer.parseInt(temp[i]);
			if(parent[i] != -1) {
				child[parent[i]].add(i);
			}
		}
		
		int del = Integer.parseInt(br.readLine().trim());

		// 로직
		int res = 0;
		boolean[] dead = new boolean[N];
		
		if(parent[del] == -1) {
			res = 0;
		}else {
			child[parent[del]].remove(0);
			
			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(del);
			
			while (!queue.isEmpty()) {
				int now = queue.poll();
				dead[now] = true;
				for (int i : child[now]) {
					queue.add(i);
				}
			}
			
			for (int i = 0; i < child.length; i++) {
				if(!dead[i] && child[i].size()==0) {
					res++;
				}
			}
		}
		
		// 출력
		System.out.println(res);
	}

}
