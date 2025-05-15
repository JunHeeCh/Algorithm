import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.nextLine();
		StringTokenizer st = new StringTokenizer(sc.nextLine(),".|:#");
		
		int result = 0;
		while (st.hasMoreTokens()) {
			String temp = st.nextToken();
			int num = Integer.parseInt(temp);
			result += num;
		}
		
		System.out.println(result);
	}
}
