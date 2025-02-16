import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//내 카드 숫자 저장
		int N = Integer.parseInt(br.readLine());
		String[] temp = br.readLine().split(" ");
		int[] cards = new int[N];
		for (int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(temp[i]);
		}
		int M = Integer.parseInt(br.readLine());
		temp = br.readLine().split(" ");
		int[] check = new int[M];
		for (int i = 0; i < M; i++) {
			check[i] = Integer.parseInt(temp[i]);
		}
		
		Arrays.sort(cards);
		
		
		for (int i : check) {
			int count = upperidx(cards,i) - loweridx(cards,i);
			bw.write(count+" ");
		}
		
		bw.flush();
	}

	private static int loweridx(int[] cards, int i) {
		int l = 0, r = cards.length;
		while(l<r) {
			int mid = (l+r)/2;
			if(cards[mid] >= i) r=mid;
			else l = mid+1;
		}
		return l;
	}

	private static int upperidx(int[] cards, int i) {
		int l = 0, r = cards.length;
		while(l<r) {
			int mid = (l+r)/2;
			if(cards[mid] > i) r=mid;
			else l = mid+1;
		}
		return l;
	}
}
