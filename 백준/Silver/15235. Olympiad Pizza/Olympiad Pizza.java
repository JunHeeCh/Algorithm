import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		Queue<person> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			int temp = sc.nextInt();
			queue.add(new person(i, temp, 0));
		}

		int[] res = new int[N];
		int time = 0;
		
		while (!queue.isEmpty()) {
			person now = queue.poll();
			
			if(now.count == 0) {
				res[now.idx] = now.time;
			}else {
				time++;
				now.count--;
				now.time = time;
				queue.add(now);
			}
			
		}//while
		
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]+" ");
		}

	}
}

class person {
	int idx;
	int count;
	int time;

	person(int idx, int count, int time) {
		this.idx = idx;
		this.count = count;
		this.time = time;
	}

}