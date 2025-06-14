import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int[][] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int K = Integer.parseInt(temp[1]);
		
		long total = 0;
		
		Queue<Integer>[] queues = new Queue[21];
		
		for (int i = 0; i < queues.length; i++) {
			queues[i] = new LinkedList();
		}
		
		for (int i = 0; i < N; i++) {
			int len = br.readLine().trim().length();
			
			if(queues[len].isEmpty()) {
				queues[len].offer(i);	//등수 삽입
				continue;
			}
			
			while (!queues[len].isEmpty()&&i-queues[len].peek()>K) {
				queues[len].poll();
			}
			
			total += queues[len].size();
			queues[len].offer(i);
		}
		
		
		
		System.out.println(total);
		
	}
}
