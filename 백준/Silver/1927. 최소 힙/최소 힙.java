
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(num == 0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(pq.poll());
				}
			}else {
				pq.add(num);
			}
		}
		
	}
}
