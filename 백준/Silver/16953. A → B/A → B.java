import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		Set<Long> set = new HashSet();
		Queue<long[]> queue = new LinkedList();
		queue.add(new long[] {A, 1});
		
		long res = 0;
		boolean isFin = false;
		
		while(!queue.isEmpty()) {
			long[] now = queue.poll();
			
			long n1 = now[0]*10+1;
			long n2 = now[0]*2;
			
			if(n1 < B && !set.contains(n1)) {
				queue.add(new long[] {n1, now[1]+1});
				set.add(n1);
			}
			if(n2 < B && !set.contains(n2)) {
				queue.add(new long[] {n2, now[1]+1});
				set.add(n2);
			}
			
			if(n1 == B || n2 == B) {
				isFin = true;
				res = now[1];
				break;
			}
		}
		
		if(isFin) {			
			System.out.print(res+1);
		}else {
			System.out.print(-1);			
		}

	}
}
