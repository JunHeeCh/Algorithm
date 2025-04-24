import java.util.Scanner;
//1241
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] array = new int[N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			array[i] = sc.nextInt();
			if(max < array[i]) {
				max = array[i];
			}
		}
		
		int[] count = new int[max+1];
		
		for (int i = 0; i < array.length; i++) {
			count[array[i]]++;
		}

		int[] res = new int[max+1];
		
		for (int i = 1; i <= max; i++) {
			if(count[i] > 1) {
				res[i] += count[i]-1;
			}
			for(int j = i*2; j <= max ; j+=i) {
				res[j] += count[i];				
			}
		}
		for (int i = 0; i < array.length; i++) {
			System.out.println(res[array[i]]);
		}
		

	}
}
