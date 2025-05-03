
import java.util.Scanner;

public class Main {
	static int min;
	static int[][] link;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		link = new int[n][n];
		
		for (int i = 0; i < link.length; i++) {
			for (int j = 0; j < link.length; j++) {
				link[i][j] = sc.nextInt();
			}
		}
		
		min = 123456789;
		boolean[] team = new boolean[n];
		nCr(n , n/2, team, 0, 0);
		
		System.out.println(min);
		
	}

	private static void nCr(int n, int c, boolean[] team, int index, int cnt) {
		if(cnt == c) {
			
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < team.length; i++) {
				if(team[i]) {
					//1번 팀
					for (int j = 0; j < team.length; j++) {
						if(team[j]) {
							sum1 += link[i][j];
						}
					}
				}else {
					//2번 팀
					for (int j = 0; j < team.length; j++) {
						if(!team[j]) {
							sum2 += link[i][j];
						}
					}
				}
			}
			
			int diff = Math.abs(sum2-sum1);
			if(diff < min) {
				min = diff;
			}
			return;
		}
		
		for (int i = index; i < n; i++) {
			team[i] = true;
			nCr(n, c, team, i+1, cnt+1);
			team[i] = false;
		}
		
	}
	
}
