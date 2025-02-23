import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static List<Integer>[] graph;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();	//컴퓨터 개수
		sc.nextLine();
		graph = new ArrayList[N+1];
		for (int i = 1; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		
		int M = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < M; i++) {
			String[] tmp = sc.nextLine().trim().split(" ");
			graph[Integer.parseInt(tmp[0])].add(Integer.parseInt(tmp[1]));
			graph[Integer.parseInt(tmp[1])].add(Integer.parseInt(tmp[0]));
		}
		
		boolean[] visited = new boolean[N+1];
		int count;
		count = bfs(1, visited);
		System.out.println(count);
		
	}
	
	public static int bfs(int start, boolean[] visited) {
		int count = 0;
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(start);
		visited[start] = true;
		
		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (Integer integer : graph[node]) {
				if(!visited[integer]) {
					queue.add(integer);
					visited[integer] = true;
					count++;
				}
			}
		}
		
		
		return count;
	}
}
