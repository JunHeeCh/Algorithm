import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] text = br.readLine().trim().toCharArray();
		char[] target = br.readLine().trim().toCharArray();

		Stack<Character> stack = new Stack<>();
		int len = target.length - 1;


		for (int i = 0; i < text.length; i++) {
			stack.add(text[i]);
			// text[i]를 검사
			if (text[i] == target[len] && stack.size() >= len+1) {
				
				Stack<Character> tempStack = new Stack<>();

				for (int j = len; j >= 0; j--) {	//뒷글자부터 검사 
					char temp = stack.pop();
					tempStack.add(temp);
					if(temp != target[j]) {
						int length = tempStack.size();
						for (int k = 0; k < length; k++) {
							stack.add(tempStack.pop());
						}
						
						break;
					}//if
				}

			}

		}

		if (stack.isEmpty()) {
			System.out.println("FRULA");
		} else {
			StringBuilder sb = new StringBuilder();
			int length = stack.size();
			for (int i = 0; i < length; i++) {
				sb.append(stack.pop());
			}
			System.out.println(sb.reverse());
		}

	}
}
