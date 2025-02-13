import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()) ;
		Stack<Integer> st = new Stack<Integer>();
		
		for (int i = 0; i < T; i++) {
			String command = br.readLine();
			if (command.equals("pop")) {
				if(st.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(st.pop());		
				}
			}else if (command.equals("size")) {
				System.out.println(st.size());
			}else if (command.equals("empty")) {
				if(st.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);				
				}
			}else if (command.equals("top")) {
				if(st.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(st.peek());				
				}
			}else {
				//push 연산
				int num = Integer.parseInt(command.split(" ")[1]);
				st.push(num);
			}
		}
	}
}
