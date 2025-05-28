import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//11866
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		int cnt = 0;
		
		while (!queue.isEmpty()) {
			int num = queue.poll();
			cnt++;
			
			if(cnt==k) {
				cnt = 0;
				if(queue.isEmpty()) {
					sb.append(num);
				}else {
					sb.append(num+", ");					
				}
			}else {
				queue.add(num);
			}
		}
		
		sb.append(">");
		
		System.out.println(sb);
		
	}
}
