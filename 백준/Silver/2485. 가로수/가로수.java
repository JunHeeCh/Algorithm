import java.util.Scanner;

//2485
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int[] diff = new int[N - 1];
		for (int i = 0; i < N - 1; i++) {
			diff[i] = arr[i + 1] - arr[i];
		}

		for (int i = 0; i < N - 2; i++) {
			// diff[i]랑 diff[i+1]의 약수를 구해서 최종적으로 하나의 수를 구하기
			diff[i+1] = gcd(diff[i], diff[i + 1]);
		}
		
		//diff[N-2]에 내가 원하는 최대공약수가 들어 있음 
		int count = (arr[N-1]-arr[0])/diff[N-2]+1;
		
		System.out.println(count-arr.length);
	}

	private static int gcd(int a, int b) {
		if (a > b) {
			// a가 더 큰 수
			// a랑 b 중에 b랑, a를 b로 나눈 나머지를 구하고
			while (b != 0) {
				int temp = b;
				b = a % b;
				a = temp;
			} // while
			return a;
		} else {
			// b가 더 큰 수
			while (a != 0) {
				int temp = a;
				a = b % a;
				b = temp;
			}
			return b;
		}
	}
}
