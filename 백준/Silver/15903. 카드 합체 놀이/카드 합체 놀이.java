import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int n = Integer.parseInt(temp[0]);
		int m = Integer.parseInt(temp[1]);

		PriorityQueue<Long> pq = new PriorityQueue<>();

		temp = br.readLine().trim().split(" ");
		for (int i = 0; i < n; i++) {
			pq.add(Long.parseLong(temp[i]));
		}

		while (m > 0) {
			long a = pq.poll();
			long b = pq.poll();
			
			long sum = (a+b);
			pq.add(sum);
			pq.add(sum);
			
			m--;
		}
		
		long res = 0;
		while (!pq.isEmpty()) {
			res += pq.poll();
		}

		System.out.println(res);
	}

}
