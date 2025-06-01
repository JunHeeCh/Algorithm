import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		int[] count = new int[2000001];
		for (int i = 0; i < N; i++) {
			count[Integer.parseInt(br.readLine().trim())+1000000]++;
		}
		
		for (int i = 0; i < count.length; i++) {
			if(count[i]>0) {
				System.out.println(i-1000000);
			}
		}
		
	}
}
