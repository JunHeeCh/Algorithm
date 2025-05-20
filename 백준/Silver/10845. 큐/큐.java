import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int min = 123456789;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> queue = new ArrayDeque<>();
		
		int N = Integer.parseInt(br.readLine().trim());
		
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().trim().split(" ");
			
			if(temp.length>1) {
				queue.add(Integer.parseInt(temp[1]));
			}else if(temp[0].equals("pop")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(queue.pollFirst());					
				}
			}else if(temp[0].equals("front")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(queue.getFirst());					
				}
			}else if(temp[0].equals("back")) {
				if(queue.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(queue.getLast());					
				}
			}else if(temp[0].equals("size")) {
				System.out.println(queue.size());
			}else if(temp[0].equals("empty")) {
				if(queue.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}

		}
		
	}
}
