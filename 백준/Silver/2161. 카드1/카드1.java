import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine().trim());

		Queue<Integer> queue = new LinkedList();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		while(queue.size() > 1) {
			sb.append(queue.poll()+" ");
			int a = queue.poll();
			queue.add(a);
		}
		
		sb.append(queue.poll());

		System.out.println(sb);

	}

}
