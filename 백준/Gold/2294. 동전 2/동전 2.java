
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		int[] coin = new int[n];
		for (int i = 0; i < n; i++) {
			coin[i] = sc.nextInt();
		}

		Arrays.sort(coin);
		int[] cnt = new int[k + 1];
		Arrays.fill(cnt, 10001);
		cnt[0] = 0;
		
		for (int i = 0; i < coin.length; i++) {
			for (int j = coin[i]; j <= k; j++) {
				if(cnt[j-coin[i]] != 10001) {
					cnt[j] = Math.min(cnt[j], cnt[j-coin[i]]+1);
				}
			}
		}

		if(cnt[k] == 10001) {
			System.out.println("-1");
		}else {
			System.out.println(cnt[k]);
		}


	}


}
