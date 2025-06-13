import java.util.Arrays;
import java.util.Scanner;

//9663
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int res = 0;
		int time = 0;
		
		for (int i = 0; i < arr.length; i++) {
			res += time+arr[i];
			time+= arr[i];
		}
		
		System.out.println(res);
		
	}
}
