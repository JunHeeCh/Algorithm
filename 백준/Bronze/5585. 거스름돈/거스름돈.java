
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] money = { 500, 100, 50, 10, 5, 1 };

		int n = sc.nextInt();

		int rest = 1000 - n;
		int cnt = 0;
		int index = 0;
		while (index < 6) {
			if(rest == 0) break;
			
			int count = rest / money[index];
			cnt += count;
			rest -= money[index] * count;
			
			index++;
		}
		
		System.out.println(cnt);
	}
}
