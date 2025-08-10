import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int time = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);
		int r = Integer.parseInt(temp[2]);
		
		List<Integer>[] list = new ArrayList[n+1];
		
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			temp = br.readLine().trim().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			list[a].add(b);
			list[b].add(a);
		}
		
		for (int i = 1; i < list.length; i++) {
			list[i].sort(null);
		}

		boolean[] visited = new boolean[n+1];
		int[] res = new int[n+1];
		
		dfs(list, visited, res, r);
		

		for (int i = 1; i < res.length; i++) {
			System.out.println(res[i]);			
		}
	}

	private static void dfs(List<Integer>[] list, boolean[] visited, int[] res, int r) {
		visited[r] = true;
		res[r] = time;
		time++;
		
		for (int i : list[r]) {
			if(!visited[i]) {
				dfs(list, visited, res, i);
			}
		}
	}

}
