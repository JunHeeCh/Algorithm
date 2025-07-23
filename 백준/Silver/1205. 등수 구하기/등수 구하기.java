import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		long score = Long.parseLong(temp[1]);
		int P = Integer.parseInt(temp[2]);

		if(N == 0) {			
			System.out.println(1);
			return;
		}
		
		
		temp = br.readLine().trim().split(" ");
		if(N == P && Long.parseLong(temp[N-1])>= score) {
			System.out.println(-1);
			return;
		}
		
		int res = 1;

		for (int i = 1; i <= N; i++) {
			long num = Long.parseLong(temp[i-1]);
			if (num > score) {
				res++;
			}else {
				break;
			}
		}

		System.out.println(res);
	}

}
