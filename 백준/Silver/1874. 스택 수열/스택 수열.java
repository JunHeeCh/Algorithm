import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();	//1~n까지 숫자 
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();

		int num = 1;
		for(; num<=arr[0]; num++) {
			stack.add(num);
			sb.append("+\n");
		}
		
		int idx = 0;	//arr의 목표 인덱스 

		boolean impossible = false; //성공 여부 
		
		while (num <= n) {
			
			if(stack.isEmpty()) {
				stack.add(num++);
				sb.append("+\n");
			}
			
			int peek = stack.peek();
			
			if(peek < arr[idx]) {
				stack.add(num++);
				sb.append("+\n");				
			}else if(peek > arr[idx]) {
				impossible = true;
				break;				
			}else {
				idx++;
				stack.pop();
				sb.append("-\n");				
			}
		}
		
		while (!stack.isEmpty() && !impossible) {
			if(stack.pop()==arr[idx]) {
				idx++;
				sb.append("-\n");				
			}else {
				impossible = true;
			}
		}
		
		if(impossible) {
			System.out.println("NO");
		}else {
			System.out.println(sb);
		}
		
		
	}
}
