import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		String[] temp = br.readLine().trim().split(" ");

		int[] cnt = new int[51];

		for (int i = 0; i < temp.length; i++) {
			int tmp = Integer.parseInt(temp[i]);
			cnt[tmp]++;
		}

		for (int i = 50; i >= 0; i--) {
			if(cnt[i] == i) {
				System.out.println(i);
				return;
			}
		}

		System.out.println(-1);

	}

}
