import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);

		int[][] board = new int[N][M];
		
		char[][] b = new char[N][M];
		for (int i = 0; i < N; i++) b[i] = br.readLine().toCharArray();

		int ans = Integer.MAX_VALUE;

		for (int si = 0; si <= N - 8; si++) {
		    for (int sj = 0; sj <= M - 8; sj++) {
		        int wStart = 0; // (si,sj)가 'W'라고 가정
		        int bStart = 0; // (si,sj)가 'B'라고 가정

		        for (int i = 0; i < 8; i++) {
		            for (int j = 0; j < 8; j++) {
		                char cur = b[si + i][sj + j];
		                boolean even = ((i + j) % 2 == 0);

		                // W-start: 짝수칸 W, 홀수칸 B
		                if (even) {
		                    if (cur != 'W') wStart++;
		                    if (cur != 'B') bStart++;
		                } else {
		                    if (cur != 'B') wStart++;
		                    if (cur != 'W') bStart++;
		                }
		            }
		        }
		        ans = Math.min(ans, Math.min(wStart, bStart));
		    }
		}

		System.out.print(ans);


	}

}

