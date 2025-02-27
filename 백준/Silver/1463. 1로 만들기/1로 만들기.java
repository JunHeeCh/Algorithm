import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Map<Integer, Integer> map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		map = new HashMap<>();
		// N -> 1 로 만들 때
		System.out.println(find(N));

	}

	public static int find(int N) {
		if (N == 1) {
			return 0;
		}
		if (!map.containsKey(N)) {
			int tmp;
			int min = (int) Math.pow(10, 6);
			// 여기 연산 적기
			if (N % 3 == 0) {
				tmp = N / 3;
				min = Math.min(min, find(tmp));
			}  
			if (N % 2 == 0) {
				tmp = N / 2;
				min = Math.min(min, find(tmp));
			}
			tmp = N - 1;
			min = Math.min(min, find(tmp));
			
			map.put(N, min + 1);
		}
		return map.get(N);

	}
}
