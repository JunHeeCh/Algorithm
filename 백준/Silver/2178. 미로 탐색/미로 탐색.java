
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Main {
//	static List<List<Integer>> allPath;
	static List<Integer>[] graph;
	static Set<Integer> visited;
	
	
	private static void makeGraph(int[][] maze, List<Integer>[] graph) {
		int[] dr = { -1, 1, 0, 0 }; // 상하좌우
		int[] dc = { 0, 0, -1, 1 };

		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				if (maze[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if (nr >= 0 && nr < maze.length && nc >= 0 && nc < maze[i].length && maze[nr][nc] != 0) {
							graph[maze[i][j]].add(maze[nr][nc]);
						}
					}
				}
			}
		}

	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 입력
		String[] temp = sc.nextLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		int[][] maze = new int[N][M];
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			char[] tmp = sc.nextLine().trim().toCharArray();
			for (int j = 0; j < M; j++) {
				if (tmp[j] == '1') {
					maze[i][j] = ++cnt;
				}
			}
		}
		// 로직

		 graph = new ArrayList[cnt + 1];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		makeGraph(maze, graph);
		// 그래프 완성
		
		
		
		visited = new HashSet<>();

		
		System.out.println(bfs(1, cnt));

	}

	


	public static int bfs(int myPosition, int goal) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int[] adding = {myPosition,0};
		queue.add(adding);
//		visited.add(myPosition);
		
		while (!queue.isEmpty()) {
			int[] pick = queue.poll();
			int position = pick[0];
			int cnt = pick[1];
			if(position==goal) {
				return cnt+1;
			}
//			System.out.println(position);
			for (Integer integer : graph[position]) {
				if(!visited.contains(integer)) {
					int[] put = {integer, cnt+1};
					visited.add(integer);
					queue.add(put);
				}
			}
		}//while
		return -1;
	}

}
