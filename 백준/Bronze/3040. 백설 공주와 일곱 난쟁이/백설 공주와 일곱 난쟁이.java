import java.util.Scanner;

public class Main {
	static boolean fin;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] nums = new int[9];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}

		int[] res = new int[7];

		nCr(res, nums, 0, 0, 0);

	}

	private static void nCr(int[] res, int[] nums, int pick, int total, int index) {
		if (fin) {
			return;
		}

		if (pick >= 7) {
			if (total == 100) {
				fin = true;
				for (int i = 0; i < res.length; i++) {
					System.out.println(res[i]);
				}
			}
			return;
		}

		for (int i = index; i < nums.length; i++) {
			res[pick] = nums[i];
			nCr(res, nums, pick + 1, total + nums[i], i + 1);
		}

	}
}
