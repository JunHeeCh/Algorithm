import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String[] num = br.readLine().split(" ");
		int[] number = new int[num.length];
		for (int i = 0; i < num.length; i++) {
			number[i] = Integer.parseInt(num[i]);
		}
		Arrays.sort(number);
		
		char[] abc = br.readLine().toCharArray();
		for (int i = 0; i < 3; i++) {
			if(abc[i]=='A') {
				System.out.print(number[0]+" ");
			}else if(abc[i]=='B') {
				System.out.print(number[1]+" ");
			}else if(abc[i]=='C') {
				System.out.print(number[2]+" ");
			}
		}
		br.close();
	}
}