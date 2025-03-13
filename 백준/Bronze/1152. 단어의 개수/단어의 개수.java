
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] st = sc.nextLine().trim().toCharArray();
		int cnt = 0;
		for (int i = 0; i < st.length; i++) {
			if(!inBoundary(st[i])) {
				cnt++;
			}
		}
		if( st.length>0 && inBoundary(st[st.length-1])) {
			cnt++;
		}
		System.out.println(cnt);

	}

	private static boolean inBoundary(char c) {
		if((c>='A' && c<='Z')||(c>='a' && c<='z')) {
			return true;
		}
		return false;
	}
}
