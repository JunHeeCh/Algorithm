import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine().trim());
		
		PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> right = new PriorityQueue<>();
		
		int mid = 0;
		
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine().trim());
			
			if(left.isEmpty() || temp <= mid) {
				left.add(temp);
			}else {
				right.add(temp);
			}
			
			if(left.size() < right.size()) {
				left.add(right.poll());
			}else if(left.size() > right.size()+1) {
				right.add(left.poll());
			}
			
			mid = left.peek();
			sb.append(mid + "\n");
		}
		
		System.out.println(sb);
	}
}
