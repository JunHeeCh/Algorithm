import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class node implements Comparable<node>{
	int idx;
	int num;
	
	public node(int idx, int num) {
		this.idx = idx;
		this.num = num;
	}

	@Override
	public int compareTo(node o) {
		return Integer.compare(this.num, o.num);
	}
}


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine().trim());

		node[] nums = new node[N];

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine().trim());
			nums[i] = new node(i+1, num);
		}
		
		Arrays.sort(nums,	(a,b) ->{
			return 	Integer.compare(a.num, b.num);
		});
		for (int i = 0; i < nums.length; i++) {
			nums[i].num = i+1;
		}
		
		Arrays.sort(nums,	(a,b) ->{
			return 	Integer.compare(a.idx, b.idx);
		});
		
		int[] seg = new int[4 * N];

		for (int i = 0; i < nums.length; i++) {
			int now = nums[i].num;
			update(seg, 1, 1, N, now, 1);
			sb.append(query(seg, 1, 1, N, now, N)+"\n");
		}
		
		System.out.println(sb);

	}

	private static int query(int[] seg, int idx, int start, int end, int left, int right) {
		if (right < start || end < left)
			return 0;

		if (left <= start && end <= right) {
			return seg[idx];
		}

		int mid = (start + end) / 2;
		int leftsum = query(seg, idx * 2, start, mid, left, right);
		int rightsum = query(seg, idx * 2 + 1, mid + 1, end, left, right);

		return leftsum + rightsum;
	}

	private static void update(int[] seg, int node, int start, int end, int idx, int diff) {
		// start, end는 원본 배열의 시작과 끝
		// idx 는 원본 배열의 수정하고자 하는 위치
		// diff는 변경하고자 하는 값

		if (idx < start || end < idx)
			return;

		seg[node] += diff;

		if (start != end) {
			update(seg, node * 2, start, (start + end) / 2, idx, diff);
			update(seg, node * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
		}

	}

}
