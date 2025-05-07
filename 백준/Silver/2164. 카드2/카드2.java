import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Deque<Integer> queue = new ArrayDeque<>();
		
		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}
		int count = N;
		
		while (count > 1) {
			queue.poll();
			
			if(queue.size()==1) {
				break;
			}
			
			int card = queue.poll();
			queue.addLast(card);
		}
		
		System.out.println(queue.poll());
	}
}
