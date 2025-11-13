import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int R = Integer.parseInt(temp[0]);
		int C = Integer.parseInt(temp[1]);

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			return Integer.compare(b[1], a[1]);
		});

		for (int i = 0; i < R; i++) {
			char[] tmp = br.readLine().trim().toCharArray();
			for (int j = 0; j < tmp.length; j++) {
				if (tmp[j] >= '1' && tmp[j] <= '9') {
					pq.add(new int[] { tmp[j] - '0', j }); // 팀 번호, 거리
					break;
				}
			}
		}

		int[] res = new int[10];
		int rank = 1;

		while (!pq.isEmpty()) {
			int[] tmp = pq.poll();
			res[tmp[0]] = rank;

			while (!pq.isEmpty() && pq.peek()[1] == tmp[1]) {
				tmp = pq.poll();
				res[tmp[0]] = rank;
			}

			rank++;
		}

		for (int i = 1; i < res.length; i++) {
			System.out.println(res[i]);
		}

	}

}
