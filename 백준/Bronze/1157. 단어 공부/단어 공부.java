
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] st = sc.nextLine().trim().toCharArray();
		
		int[] cnt = new int[26];
		for (int i = 0; i < st.length; i++) {
			if(st[i] > 96 ) {
				//소문자
				cnt[st[i]-97]++;
			}else {
				cnt[st[i]-65]++;
			}
		}
		
		int max = 0;
		char character = 0;;
		for (int i = 0; i < cnt.length; i++) {
			if(max < cnt[i]) {
				max = cnt[i];
				character = (char) i;
			}
		}
		
		Arrays.sort(cnt);
		int len = cnt.length;
		if(cnt[len-1] == cnt[len-2]) {
			System.out.println("?");
		}else {
			character += 65;
			System.out.println(character);
		}
		
		
	}
}
