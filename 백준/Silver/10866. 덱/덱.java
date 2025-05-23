
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

//10866
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		Deque<Integer> queue = new LinkedList<>();
		
		for (int i = 0; i <N; i++) {
			String[] temp = br.readLine().trim().split(" ");
			if(temp[0].equals("push_front")) {
				queue.addFirst(Integer.parseInt(temp[1]));
			}else if(temp[0].equals("push_back")) {
				queue.addLast(Integer.parseInt(temp[1]));
			} else if(temp[0].equals("pop_front")) {
				if(queue.size()>0) {
					System.out.println(queue.pollFirst());;
				}else {
					System.out.println(-1);
				}
				
			}else if(temp[0].equals("pop_back")) {
				if(queue.size()>0) {
					System.out.println(queue.pollLast());;
				}else {
					System.out.println(-1);
				}
			}else if(temp[0].equals("size")) {
				System.out.println(queue.size());
			}else if(temp[0].equals("empty")) {
				if(queue.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
			}else if(temp[0].equals("front")) {
				if(queue.size()>0) {
					System.out.println(queue.peekFirst());;
				}else {
					System.out.println(-1);
				}
			}else if(temp[0].equals("back")) {
				if(queue.size()>0) {
					System.out.println(queue.peekLast());;
				}else {
					System.out.println(-1);
				}
			}
		}
	}
}
