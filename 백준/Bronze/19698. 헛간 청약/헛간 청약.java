import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().trim().split(" ");

		int N = Integer.parseInt(temp[0]);
		int W = Integer.parseInt(temp[1]);
		int H = Integer.parseInt(temp[2]);
		int L = Integer.parseInt(temp[3]);

		W /= L;
		H /= L;

		if (W * H > N) {
			System.out.println(N);
		} else {
			System.out.println(W * H);
		}

	}

}
