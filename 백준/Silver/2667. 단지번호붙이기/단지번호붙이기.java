import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String[] tmp = br.readLine().trim().split("");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
			}
		}

		int num = 1;
		int[][] numbered = new int[N][N];

		for (int i = 0; i < numbered.length; i++) {
			for (int j = 0; j < numbered.length; j++) {
				if (arr[i][j] != 0) {
					numbered[i][j] = num++;
				}
			}
		} // numbered에 숫자 넣기

		int[] dr = { 1, 0 }; // 하,우
		int[] dc = { 0, 1 };

		List<Integer>[] graph = new ArrayList[num];
		for (int i = 1; i < num; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < numbered.length; i++) {
			for (int j = 0; j < numbered.length; j++) {
				if (numbered[i][j] != 0) {
					for (int k = 0; k < 2; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if (nr >= 0 && nr < N && nc >= 0 && nc < N && arr[nr][nc] != 0) {
							graph[numbered[i][j]].add(numbered[nr][nc]);
							graph[numbered[nr][nc]].add(numbered[i][j]);
						}
					}
				}
			}
		}
		// 여기까지 그래프를 생성함->bfs를 사용하는게 좋을듯
		boolean[] visited = new boolean[num];
		int[] set = new int[num];	//몇번 타운에 속하는지 저장

		int town = 0; //타운 개수
		for (int i = 1; i < num; i++) {
			if(set[i] ==0) {
				town++;
				bfs(graph, i, set, visited, town);
			}
		} 
		int[] count = new int[town];
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < set.length; j++) {
				if(i+1 == set[j]) {
					count[i]++;
				}
			}
		}
		System.out.println(town);
		Arrays.sort(count);
		for (int i = 0; i < count.length; i++) {
			System.out.println(count[i]);
			
		}

	}

	static void bfs(List<Integer>[] graph, int start, int[] set, boolean[] visitedBfs, int town) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visitedBfs[start] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();
			set[node] = town;
			for (int next : graph[node]) {
				if (!visitedBfs[next]) {
					queue.add(next);
					visitedBfs[next] = true;
				}
			}
		}

	}
}
