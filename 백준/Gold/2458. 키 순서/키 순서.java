import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");

		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);

		boolean[][] down = new boolean[N + 1][N + 1];
		boolean[][] up = new boolean[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			temp = br.readLine().trim().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);

			down[a][b] = true;
			up[b][a] = true;
		}

		for (int i = 1; i < N + 1; i++) {
			down[i][i] = true;
			up[i][i] = true;
		}

		for (int k = 1; k < up.length; k++) {
			for (int i = 1; i < up.length; i++) {
				for (int j = 1; j < up.length; j++) {
					
					if(i!= j && down[i][k] && down[k][j]) {
						down[i][j] = true;
					}
					if(i!= j && up[i][k] && up[k][j]) {
						up[i][j] = true;
					}
					
				}
			}
		}
		
		int res = 0;
		for (int i = 1; i < up.length; i++) {
			int count = 0;
			for (int j = 1; j < up.length; j++) {
				if(i != j) {
					if(down[i][j] || up[i][j]) {
						count++;
					}
				}
			}
			if(count == N-1) {
				res++;
			}
		}
		
		
		System.out.println(res);

	}
}
