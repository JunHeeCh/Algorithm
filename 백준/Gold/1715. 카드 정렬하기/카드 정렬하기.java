import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int min = 123456789;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			pq.add(sc.nextInt());
		}
		//입력 완료
		int res = 0;
		
		while(pq.size()>1) {
			int a = pq.poll();
			int b = pq.poll();
			res += a+b;
			pq.add(a+b);
		}
		
		System.out.println(res);
		
	}
}
