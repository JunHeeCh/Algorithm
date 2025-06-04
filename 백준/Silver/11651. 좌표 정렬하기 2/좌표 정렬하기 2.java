import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		PriorityQueue<point> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			pq.add(new point(a, b));
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(pq.poll().toString());
		}
		
	}
}

class point implements Comparable<point>{
	int x;
	int y;

	point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return x + " " + y;
	}

	@Override
	public int compareTo(point o) {
		if(this.y==o.y) {
			return Integer.compare(this.x, o.x);
		}
		return Integer.compare(this.y, o.y);
	}
	
	
}
