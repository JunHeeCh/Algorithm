import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] temp = br.readLine().toCharArray();

		int[] num = new int[10];
		for (int i = 0; i < temp.length; i++) {
			int tmp = temp[i] - '0';
			
			num[tmp]++;
		}

		int max = -1;
		int idx = -1;
		for (int i = 0; i < num.length; i++) {
			max = Math.max(max, num[i]);
			idx = i;
		}

		if (idx != 6 && idx != 9) {
			System.out.println(max);
			return;
		}
		
		int sum = num[6] + num[9];
		if (sum % 2 != 0) {
			sum /= 2;
			sum += 1;
		} else {
			sum /= 2;
		}

		max = -1;
		for (int i = 0; i < num.length; i++) {
			if(i==6 || i == 9) {
				continue;
			}
			max = Math.max(max, num[i]);
		}
		
		max = Math.max(max, sum);
		System.out.println(max);
	}

}
