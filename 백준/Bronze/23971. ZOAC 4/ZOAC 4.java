import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");

		int H = Integer.parseInt(temp[0]);
		int W = Integer.parseInt(temp[1]);
		int N = Integer.parseInt(temp[2]);
		int M = Integer.parseInt(temp[3]);

		/*
		 * 1+n X 1+m 이 1인의 영역
		 * 
		 */

		int a = H / (1 + N);
		if (H % (1 + N) > 0) {
			a++;
		}
		int b = W / (1 + M);
		if (W % (1 + M) > 0) {
			b++;
		}

		System.out.print(a * b);

	}
}
