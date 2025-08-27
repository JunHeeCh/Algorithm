import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); // 수의 변경 횟수
		int K = Integer.parseInt(st.nextToken()); // 구간합 계산 횟수

		long[] nums = new long[N];

		for (int i = 0; i < N; i++) {
			nums[i] = Long.parseLong(br.readLine().trim());
		}

		long[] tree = new long[N * 4];

		init(nums, tree, 1, 0, N - 1);

		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine().trim());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()) - 1;
			long c = Long.parseLong(st.nextToken());

			if (a == 1) {
				// b번째 수를 c로 변경
				long diff = c - nums[b];
				update(tree, 1, b, diff, 0, N - 1);
				nums[b] = c;
			} else {
				// b번째 수부터 c번째 수까지의 합
				sb.append(query(tree, 1, 0, N - 1, b, (int) c - 1) + "\n");
			}
		}

		System.out.println(sb);

	}

	private static long query(long[] tree, int node, int start, int end, int left, int right) {
		if (right < start || end < left)
			return 0;

		if (left <= start && end <= right) {
			return tree[node];
		}

		int mid = (start + end) / 2;
		long leftSum = query(tree, node * 2, start, mid, left, right);
		long rightSum = query(tree, node * 2 + 1, mid + 1, end, left, right);

		return leftSum + rightSum;
	}

	private static void update(long[] tree, int node, int change, long diff, int start, int end) {
		if (change < start || end < change)
			return;

		tree[node] += diff;

		if (start != end) {
			int mid = (start + end) / 2;
			update(tree, node * 2, change, diff, start, mid);
			update(tree, node * 2 + 1, change, diff, mid + 1, end);
		}

	}

	private static void init(long[] nums, long[] tree, int node, int start, int end) {
		// node는 트리의 인덱스
		if (start == end) {
			tree[node] = nums[start];
			return;
		}

		int mid = (start + end) / 2;
		init(nums, tree, node * 2, start, mid);
		init(nums, tree, node * 2 + 1, mid + 1, end);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];

	}

}
