
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

//SugarDelivery
//2839
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] num = new int[n+1];
		boolean[] visited = new boolean[n+1];
		
		Arrays.fill(num, -1);
		num[3] = 1;
		if(n>4) {			
			num[5] = 1;
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		pq.add(3);
		pq.add(5);
		
		int number = pq.poll();
		
		while (number <= n && !pq.isEmpty()) {
			if(number+3 <= n) {
				if(num[number+3] == -1) {
					num[number+3] = num[number]+1;				
				}else {
					num[number+3] = Math.min(num[number+3], num[number]+1);
				}
			}
			
			if(number+5 <= n) {
				if(num[number+5] == -1) {
					num[number+5] = num[number]+1;				
				}else {
					num[number+5] = Math.min(num[number+5], num[number]+1);
				}
			}
			if(number+3 <= n && !visited[number+3]) {
				visited[number+3] = true;
				pq.add(number+3);
			}
			if(number+5 <= n && !visited[number+5]) {
				visited[number+5] = true;
				pq.add(number+5);
			}
			
			number = pq.poll();
			
		}
		
		System.out.println(num[n]);
	}
}
