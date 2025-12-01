import java.io.*;
import java.util.*;

public class Main {
	static int[] dr = new int[] { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dc = new int[] { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		int[] arr = new int[N];
		String[] temp = br.readLine().trim().split(" ");

		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}

		temp = br.readLine().trim().split(" ");
		int B = Integer.parseInt(temp[0]);
		int C = Integer.parseInt(temp[1]);

		long answer = N;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] - B > 0) {
				answer += (arr[i] - B) / C;
				if ((arr[i] - B) % C > 0) {
					answer++;
				}
			}
		}

		System.out.println(answer);

	}

}
