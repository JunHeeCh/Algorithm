import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
	static List<Integer> visited = new ArrayList<>();
			
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		getnum(N,M);
	}

	private static void getnum(int n, int m) {
		if(visited.size()==m) {
			for (Integer integer : visited) {
				System.out.print(integer+" ");
			}
			System.out.println();
		}
		
		for (int i = 1; i <= n; i++) {
			if(!visited.contains(i)) {
				if(visited.isEmpty() || visited.get(visited.size()-1)<i) {
					visited.add(i);		
					getnum(n, m);
					visited.remove(visited.size()-1);
				}
			}
		}
		
		
		
	}
}
