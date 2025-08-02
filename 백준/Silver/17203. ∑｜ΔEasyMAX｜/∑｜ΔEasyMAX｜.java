import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int[] beat = new int[N];
		String[] temp = br.readLine().trim().split(" ");

		for (int i = 0; i < beat.length; i++) {
			beat[i] = Integer.parseInt(temp[i]);
		}

		for (int i = 0; i < Q; i++) {
			temp = br.readLine().trim().split(" ");
			int start = Integer.parseInt(temp[0])-1;
			int end = Integer.parseInt(temp[1])-1;

			int sum = 0;
			if (end - 1 < start) {
				System.out.println(0);
			} else {
				for (int j = start; j < end; j++) {
					sum += Math.abs(beat[j + 1] - beat[j]);
				}
				System.out.println(sum);
			}
		}

	}

}
