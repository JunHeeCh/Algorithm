import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		while (!queue.isEmpty()) {
			for (int i = 0; i < K-1; i++) {
				int num = queue.poll();
				queue.add(num);
			}
			if(queue.size() != 1) {
				sb.append(queue.poll()+", ");				
			}else {
				sb.append(queue.poll());								
			}
		}
		
		sb.append(">");
		System.out.println(sb);
	}
}