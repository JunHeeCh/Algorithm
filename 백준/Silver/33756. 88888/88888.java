import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static Map<Integer, Long> map = new HashMap<>();

	public static void main(String[] args) {
		map.put(1, (long) 1);
		map.put(2, (long) 11);
		map.put(3, (long) 111);
		map.put(4, (long) 1111);
		map.put(5, (long) 11111);
		map.put(6, (long) 111111);
		map.put(7, (long) 1111111);
		map.put(8, (long) 11111111);
		map.put(9, (long) 111111111);
		map.put(10, (long) 1111111111);
		map.put(11, 11111111111L);
		map.put(12, 111111111111L);
		map.put(13, 1111111111111L);
		map.put(14, 11111111111111L);
		map.put(15, 111111111111111L);
		map.put(16, 1111111111111111L);
		map.put(17, 11111111111111111L);
		map.put(18, 111111111111111111L);

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		sc.nextLine();

		tc: for (int tc = 1; tc <= T; tc++) {
			String num = sc.nextLine().trim();
			long N = Long.parseLong(num);

			long mock = N / 8;
			long remain = N % 8;

			if (remain > 0) {
				System.out.println("No");
				continue;
			}

			if (check(mock)) {
				System.out.println("Yes"); // 수정하기
				continue;
			}

			char[] check = num.toCharArray();
			for (int i = 0; i < check.length; i++) {
				if (check[i] != '8') {
					System.out.println("No");
					continue tc;
				}
			}

			System.out.println("Yes");
			continue;

		} // tc
	}

	private static boolean check(long mock) {
		int length = getlength(mock);

		long rest = mock;
		int time = 0;

		for (int i = 1; i <= 8; i++) {
			// 8번까지 도전 가능
			if (rest == 0)
				break;

			long test = map.get(length);
			int m = (int) (rest / test); // 몫
			if (m > 0) {
				time += m;
				rest = rest % map.get(length);
				length = getlength(rest);
			}else {
				test = map.get(length-1);
				m = (int) (rest / test);
				time += m;
				rest = rest % map.get(length);
				length = getlength(rest);
			}
		}
		
		if(time > 8 || rest != 0) {
			return false;
		}else {
			return true;
		}

	}

	private static int getlength(long mock) {
		String temp = Long.toString(mock);
		char[] tmp = temp.toCharArray();
		return temp.length();
	}
}
