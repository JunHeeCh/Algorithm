
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] temp = sc.nextLine().trim().toCharArray();
		//97 ~ 122
		int[] loc = new int[26];
		for (int i = 0; i < loc.length; i++) {
			loc[i] = -1;
		}
		
		for (int i = 0; i < temp.length; i++) {
			int num = temp[i]-97;
			if(loc[num] == -1) {
				loc[num] = i;
			}
		}
		
		for (int i = 0; i < loc.length; i++) {
			System.out.print(loc[i]+" ");
		}
	}
}	
