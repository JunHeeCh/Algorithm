
import java.util.Scanner;

public class Main {
	static int count;
	static long[][] cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		cnt = new long[N][2];
		cnt[0][0] = 0;
		cnt[0][1] = 1;
		makeCnt(N, 1);
		System.out.println(cnt[N-1][0]+cnt[N-1][1]);
	}
	private static void makeCnt(int n, int idx) {
		if(idx == n) {
			return;
		}
		long zeroCnt = cnt[idx-1][0];
		long oneCnt = cnt[idx-1][1];
		cnt[idx][0] = zeroCnt+oneCnt;
		cnt[idx][1] = zeroCnt;
		makeCnt(n, idx+1);
	}


}
