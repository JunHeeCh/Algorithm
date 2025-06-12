import java.util.Scanner;
import java.util.Stack;
//9095 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();	
		
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int res = 0;
			
			int x = n/3;
			
			for (int j = 0; j <= x; j++) {
				int rest = n-(3*j);
				int y = rest/2;
				
				for (int k = 0; k <=y; k++) {
					//j, k, z가 나왔어 
					int z = rest-(2*k);
					//조합을 해야겠네... 
					int cal = 1;	//분자 
					for (int l = 1; l <= j+k+z; l++) {
						cal *= l;
					}
					int cal2 = 1; 	//분모
					for (int l = 1; l <=j; l++) {
						cal2 *= l;
					}
					for (int l = 1; l <=k; l++) {
						cal2 *= l;
					}
					for (int l = 1; l <=z; l++) {
						cal2 *= l;
					}
					
					res += cal/cal2;
				}
				
			}
			
			System.out.println(res);
		}//T
		
	}
}
