import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		node[] ls = new node[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			ls[i] = new node(a, b, c, d);
		}

		Arrays.sort(ls);

		int cnt = 0;
		int[] res = new int[N];
		res[0] = 1;

		if (ls[0].no == K) {
			System.out.println(1);
			return;
		}

		for (int i = 1; i < ls.length; i++) {
			if (ls[i - 1].gold == ls[i].gold && ls[i - 1].silver == ls[i].silver && ls[i - 1].bronze == ls[i].bronze) {
				res[i] = res[i - 1];
			} else {
				res[i] = i + 1;
			}

			if (ls[i].no == K) {
				cnt = res[i];
				break;
			}
		}

		System.out.println(cnt);

	}

}

class node implements Comparable<node> {
	int no;
	int gold;
	int silver;
	int bronze;

	public node(int no, int gold, int silver, int bronze) {
		this.no = no;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}

	@Override
	public int compareTo(node o) {
		if (this.gold != o.gold)
			return Integer.compare(o.gold, this.gold);
		if (this.silver != o.silver)
			return Integer.compare(o.silver, this.silver);
		if (this.bronze != o.bronze)
			return Integer.compare(o.bronze, this.bronze);
		return 0;
	}

}
