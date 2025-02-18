import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			char[] ab = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			stack.add(ab[0]);
			for (int j = 1; j < ab.length; j++) {
				if(!stack.isEmpty() && stack.peek() == ab[j]) {
					stack.pop();
				}else {
					stack.add(ab[j]);
				}
			}
			if(stack.isEmpty()) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
