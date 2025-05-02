import java.util.Scanner;

//1182
public class Main {
	static int cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int S = sc.nextInt();
		
		int[] num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		cnt = 0;
		powerset(num, S, 0, 0);
		
		if(S == 0) {
			cnt--;
		}
		System.out.println(cnt);
	}

	private static void powerset(int[] num, int goal, int index, int sum) {
		if(index == num.length) {
			if(sum == goal) {
				cnt++;
			}
			return;
		}
		
		powerset(num, goal, index+1, sum);
		powerset(num, goal, index+1, sum+num[index]);
		
	}
}
