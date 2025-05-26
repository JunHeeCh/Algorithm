
import java.util.Scanner;

// 2908
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		String[] st1 = String.valueOf(a).split("");
		String[] st2 = String.valueOf(b).split("");
		
		int A = 100*Integer.parseInt(st1[2])+10*Integer.parseInt(st1[1])+Integer.parseInt(st1[0]);
		int B = 100*Integer.parseInt(st2[2])+10*Integer.parseInt(st2[1])+Integer.parseInt(st2[0]);
		
		if(A>B) {
			System.out.println(A);
		}else {
			System.out.println(B);
		}
	}
}
