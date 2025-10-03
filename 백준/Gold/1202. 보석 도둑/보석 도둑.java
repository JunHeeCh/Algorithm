import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");

		int N = Integer.parseInt(temp[0]);
		int K = Integer.parseInt(temp[1]);

		// 보석 정보 저장 (무게, 가격)
		int[][] jewelry = new int[N][2];

		for (int i = 0; i < N; i++) {
			temp = br.readLine().trim().split(" ");
			jewelry[i][0] = Integer.parseInt(temp[0]); // 무게
			jewelry[i][1] = Integer.parseInt(temp[1]); // 가격
		}

		// 가방 용량 저장
		int[] bags = new int[K];
		for (int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine().trim());
		}

		// 보석을 무게 기준 오름차순 정렬 (무게가 같으면 가격 내림차순)
		Arrays.sort(jewelry, (a, b) -> {
			if (a[0] == b[0]) {
				return b[1] - a[1];
			}
			return a[0] - b[0];
		});

		// 가방을 용량 기준 오름차순 정렬
		Arrays.sort(bags);

		// 최대 힙 (가격이 높은 순)
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

		long res = 0;
		int idx = 0; // 보석 인덱스

		// 작은 가방부터 순회
		for (int i = 0; i < K; i++) {
			int bagCapacity = bags[i];

			// 현재 가방에 담을 수 있는 모든 보석을 우선순위 큐에 추가
			while (idx < N && jewelry[idx][0] <= bagCapacity) {
				pq.offer(jewelry[idx][1]);
				idx++;
			}

			// 가장 비싼 보석 선택
			if (!pq.isEmpty()) {
				res += pq.poll();
			}
		}

		System.out.println(res);
	}

}