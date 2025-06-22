import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		// 입력

		int N = sc.nextInt();
		int K = sc.nextInt();

		// 로직 
		int[] visited = new int[100001];
		Arrays.fill(visited, -1);

		PriorityQueue<Position> queue = new PriorityQueue<>();

		queue.add(new Position(0, N));

		while (!queue.isEmpty()) {
			Position now = queue.poll();
			
			if(visited[now.loc] != -1) continue;
			
			visited[now.loc] = now.time;

			if (now.loc == K) {
				break;
			}
			if (now.loc - 1 >= 0 && visited[now.loc - 1] == -1) {
				queue.add(new Position(now.time + 1, now.loc - 1));
			}
			if (now.loc + 1 < 100001 && visited[now.loc + 1] == -1) {
				queue.add(new Position(now.time + 1, now.loc + 1));
			}

			if (now.loc * 2 >= 0 && now.loc * 2 < 100001 && visited[now.loc * 2] == -1) {
				queue.add(new Position(now.time, now.loc * 2));
			}
		}

		// 출력
		System.out.println(visited[K]);
	}

	static class Position implements Comparable<Position> {
		int time;
		int loc;

		private Position(int time, int loc) {
			this.time = time;
			this.loc = loc;
		}

		@Override
		public int compareTo(Position o) {
			return Integer.compare(this.time, o.time);
		}

	}

}
