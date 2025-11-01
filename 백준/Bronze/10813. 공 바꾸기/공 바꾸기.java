import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().trim().split(" ");

		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);

		int[] ball = new int[N + 1];

		for (int i = 0; i < ball.length; i++) {
			ball[i] = i;
		}

		for (int i = 0; i < M; i++) {
			temp = br.readLine().trim().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);

			int tmp = ball[a];
			ball[a] = ball[b];
			ball[b] = tmp;

		}

		for (int i = 1; i < ball.length; i++) {
			System.out.print(ball[i] + " ");
		}
	}

}
