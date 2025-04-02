import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//1504
public class Main {

	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");

		int N = Integer.parseInt(temp[0]);
		int E = Integer.parseInt(temp[1]);

		List<nodeC>[] list = new ArrayList[N + 1];

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			String[] tmp = br.readLine().trim().split(" ");
			int s = Integer.parseInt(tmp[0]);
			int e = Integer.parseInt(tmp[1]);
			int c = Integer.parseInt(tmp[2]);

			list[s].add(new nodeC(e, c));
			list[e].add(new nodeC(s, c));

		}

		String[] must = br.readLine().trim().split(" ");
		int must1 = Integer.parseInt(must[0]);
		int must2 = Integer.parseInt(must[1]);

		// 입력 완료
		int result = 0;
		// 방법 1 -> 1 -> must1 -> must2 -> N
		int mini = check(1, must1, must2, N, list);
		// 방법 2 -> 1 -> must2 -> must1 -> N
		int mini2 = check(1, must2, must1, N, list);

		// 혹은 둘다 -1이면 -1 출력
		if (mini == -1 && mini2 == -1) {
			result = -1;
		}
		// 둘 중 하나가 -1이라면 나머지 하나를 출력
		else if (mini == -1 || mini2 == -1) {
			result = Math.max(mini, mini2);
		}

		// 둘 다 정상이라면 최소값 출력
		else {
			result = Math.min(mini, mini2);
		}

		System.out.println(result);
	}

	
	//혹시 중간에 stop을 들리는 경우를 확인해야 함 
	
	private static int check(int start, int stop1, int stop2, int end, List<nodeC>[] list) {
		int first = dieik(list, start, stop1);
		if (first == -1) {
			return -1;
		}
		int second = dieik(list, stop1, stop2);
		if (second == -1) {
			return -1;
		}
		int third = dieik(list, stop2, end);
		if (third == -1) {
			return -1;
		}
		return first + second + third;
	}

	private static int dieik(List<nodeC>[] list, int start, int end) {

		PriorityQueue<nodeC> pq = new PriorityQueue<>();
		int[] distance = new int[list.length];
		Arrays.fill(distance, INF);

		pq.offer(new nodeC(start, 0));
		distance[start] = 0;

		while (!pq.isEmpty()) {
			nodeC now = pq.poll();

			if (distance[now.my] < now.cost)
				continue;

			for (nodeC next : list[now.my]) {
				if (distance[next.my] > distance[now.my] + next.cost) {
					distance[next.my] = distance[now.my] + next.cost;
					pq.offer(new nodeC(next.my, distance[next.my]));
				}
			}

		} // while

		if (distance[end] >= INF) {
			return -1;
		}
		return distance[end];

	}
}

class nodeC implements Comparable<nodeC> {
	int my;
	int cost;

	public nodeC(int my, int cost) {
		this.my = my;
		this.cost = cost;
	}

	@Override
	public int compareTo(nodeC o) {
		return Integer.compare(this.cost, o.cost);
	}

}