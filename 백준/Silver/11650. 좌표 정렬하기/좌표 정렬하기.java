import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		PriorityQueue<node> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			pq.add(new node(a,b));
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(pq.poll().toString());
		}
	}


}

class node implements Comparable<node>{
	int x;
	int y;
	
	node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(node o) {
		if(this.x == o.x) {
			return Integer.compare(this.y, o.y);
		}
		return Integer.compare(this.x, o.x);
	}

	@Override
	public String toString() {
		return x + " " + y ;
	}
	
	
	
}