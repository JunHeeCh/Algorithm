import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//1074
public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int N =sc.nextInt();
		int r =sc.nextInt();
		int c =sc.nextInt();
		
		int res = 0;
		
		while (N>=1) {
			int box = (int) Math.pow(2, 2*N-2);
			int layer = (int) Math.pow(2,N-1);
			if(r < layer) {
				//0 혹은 1 중에 하나 
				if(c < layer) {
					//0 
				}else {
					//1
					res += box;
					c -= layer;
				}
			}else {
				//2 혹은 3 중에 하나 
				if(c < layer) {
					//2
					res += 2*box;
					r -= layer;
				}else {
					//3
					res += 3*box;
					r -= layer;
					c -= layer;
				}
			}
			N--;
			
		}//while

		
		System.out.println(res);
	}
}


