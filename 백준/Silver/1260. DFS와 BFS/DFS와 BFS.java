import java.util.*;

public class Main {
	static List<Integer>[] graph;

	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		String[] nml = sc.nextLine().trim().split(" ");
		int N = Integer.parseInt(nml[0]);
		int M = Integer.parseInt(nml[1]);
		int L = Integer.parseInt(nml[2]);

		graph = new ArrayList[N + 1];
		boolean[] visitedDfs = new boolean[N + 1];
		boolean[] visitedBfs = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			String[] temp = sc.nextLine().trim().split(" ");
			int node1 = Integer.parseInt(temp[0]);
			int node2 = Integer.parseInt(temp[1]);
			graph[node1].add(node2);
			graph[node2].add(node1);

		}
		//로직
		for (int i = 1; i < N+1; i++) {
			//그래프 정렬
			graph[i].sort(null);
		}
		StringBuilder sd = new StringBuilder();
		StringBuilder sb = new StringBuilder();//출력할 문장
		dfs(L, sd, visitedDfs);
		bfs(L, sb, visitedBfs);

		System.out.println(sd);
		System.out.println(sb);
	}

	static void dfs(int start, StringBuilder sd, boolean[] visitedDfs) {

		visitedDfs[start] = true;
		sd.append(start + " ");
		
		for (int next : graph[start]) {
			if (!visitedDfs[next]) {
				dfs(next, sd, visitedDfs);
			}
		}
		
	}

	static void bfs(int start, StringBuilder sb, boolean[] visitedBfs) {
		for (int i = 0; i < visitedBfs.length; i++) {
			visitedBfs[i] = false;
		}
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visitedBfs[start] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();
			sb.append(node + " ");
			for (int next : graph[node]) {
				if (!visitedBfs[next]) {
					queue.add(next);
					visitedBfs[next] = true;
				}
			}
		}


	}
}
