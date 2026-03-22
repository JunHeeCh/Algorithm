import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");

		int L = Integer.parseInt(temp[0]);
		int C = Integer.parseInt(temp[1]);

		temp = br.readLine().trim().split(" ");
		
		char[] arr = new char[C];
		for (int i = 0; i < C; i++) {
			arr[i] = temp[i].charAt(0);
		}
		
		char[] ans = new char[L];
		Arrays.sort(arr);
		
		func(arr, ans, 0, 0);


	}

	private static void func(char[] arr, char[] ans, int idx, int start) {
		if(idx == ans.length) {
			if(check(ans)) {
				System.out.println(new String(ans));
			}
			return;
		}
		
		for(int i=start; i<arr.length; i++) {
			ans[idx] = arr[i];
			func(arr, ans, idx+1, i+1);
		}
		
	}

	private static boolean check(char[] ans) {
		int a = 0, b = 0;
		for(int i=0; i<ans.length; i++) {
			if(ans[i]=='a' || ans[i]=='e' || ans[i]=='i' || ans[i]=='o' || ans[i]=='u') {
				a++;
			}else {
				b++;
			}
		}
		if(a>=1 && b>=2) {
			return true;
		}
		return false;
	}

}