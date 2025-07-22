import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = new int[] { -1, 1, 0, 0 };
	static int[] dc = new int[] { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);

		boolean[][] light = new boolean[N][N];
		light[0][0] = true;

		List<int[]>[][] list = new ArrayList[N][N];

		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[0].length; j++) {
				list[i][j] = new ArrayList<int[]>();
			}
		}

		for (int i = 0; i < M; i++) {
			temp = br.readLine().trim().split(" ");
			int x = Integer.parseInt(temp[0]) - 1;
			int y = Integer.parseInt(temp[1]) - 1;
			int a = Integer.parseInt(temp[2]) - 1;
			int b = Integer.parseInt(temp[3]) - 1;
			list[x][y].add(new int[] { a, b });
		}

		
		
		boolean flag = true;
		while(flag) {
			flag = false;
			
			boolean[][] visited = new boolean[N][N];
			visited[0][0] = true;

			Queue<int[]> q = new LinkedList<>();
			q.add(new int[] { 0, 0 });
			
			while(!q.isEmpty()) {
				int[] now = q.poll();
				
				for (int[] arr : list[now[0]][now[1]]) {
					if (!light[arr[0]][arr[1]]) {  // 새로 켜지는 경우만
				        light[arr[0]][arr[1]] = true;
				        flag = true;
				    }
				}
				
				for (int i = 0; i < dr.length; i++) {
					int nr = now[0] + dr[i];
					int nc = now[1] + dc[i];
					
					if (nr < 0 || nr >= N || nc < 0 || nc >= N || !light[nr][nc] || visited[nr][nc]) {
						continue;
					}
					
					q.add(new int[] {nr,nc});
					visited[nr][nc] = true;
				}//dr
				
			}//while
			
		}


		int res = 0;
		for (int i = 0; i < light.length; i++) {
			for (int j = 0; j < light[0].length; j++) {
				if(light[i][j]) {
					res++;
				}
			}
		}
		System.out.println(res);
	}


}
