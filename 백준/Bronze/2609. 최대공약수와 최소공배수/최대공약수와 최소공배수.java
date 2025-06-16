import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int multi = a*b;
		
		if(b>a) {
			int temp = a;
			a=b;
			b=temp;
		}
		
		while (a%b != 0) {
			int temp = b;
			b = a%b;
			a = temp;
		}
		
		int least = b;
		
		int max = multi/least;
		
		System.out.println(least);
		System.out.println(max);
	}
}
