import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Integer> visitied = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		// 1~N 사이의 숫자 중 중복 없이 M개 선택
		getnum(N, M);
		
	}

	public static void getnum(int n, int m) {

		if (visitied.size() == m) {
			for (Integer integer : visitied) {
				System.out.print(integer+" ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i < n + 1; i++) {
			if (!visitied.contains(i)) {
				visitied.add(i);
				getnum(n, m);
				visitied.remove(visitied.size()-1);
			}
		}
		

	}
}
