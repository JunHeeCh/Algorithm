
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			if(n == 0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(pq.poll().num);
				}
			}else {
				pq.add(new node(n));
			}
			
		}
		
		
	}
	
	static class node implements Comparable<node>{
		int num;
		int abs;
		
		public node(Integer number) {
			this.num = number;
			this.abs = Math.abs(number);
		}

		@Override
		public int compareTo(node o) {
			if(this.abs == o.abs) {
				return Integer.compare(this.num, o.num);
			}
			return Integer.compare(this.abs, o.abs);
		}
	}
}
