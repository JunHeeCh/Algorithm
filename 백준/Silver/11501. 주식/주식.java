
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 0; tc < T; tc++) {
			int n = Integer.parseInt(br.readLine().trim());
			String[] temp = br.readLine().trim().split(" "); // 길이가 n임
			int[] num = new int[n];
			int[] sign = new int[n];

			for (int i = 0; i < n; i++) {
				num[i] = Integer.parseInt(temp[i]);
			}

			Stack<Integer> stack = new Stack<>(); // 인덱스를 넣자

			for (int i = 0; i < n; i++) {
				while (!stack.isEmpty() && num[stack.peek()] < num[i]) {
					sign[stack.pop()] = -1;
					sign[i] = 1;
				}
				stack.add(i);
			}

			long answer = 0;
			int count = 0;
			for(int i=0; i<sign.length; i++) {
				if(sign[i]<0) {
					answer -= num[i];
					count++;
				}else if (sign[i]>0) {
					answer += count*num[i];
					count = 0;
				}
			}
			System.out.println(answer);

		}

	}

}