
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int[] as = new int[A];
		int[] bs = new int[B];
		
		Set<Integer> set = new HashSet();
		
		for (int i = 0; i < A; i++) {
			as[i] = sc.nextInt();
			set.add(as[i]);
		}
		
		for (int i = 0; i < B; i++) {
			bs[i] = sc.nextInt();
			if(set.contains(bs[i])) {
				set.remove(bs[i]);
			}else {
				set.add(bs[i]);
			}
		}
		
		System.out.println(set.size());
		
	}
}
