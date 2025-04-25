
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		int[] a = new int[N];
		int[] b= new int[N*2];
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			b[i] = Integer.parseInt(st.nextToken());
			b[N+i] = b[i];
		}
		
		max = 0;
	
		for (int i = 0; i < a.length; i++) {
			int total = 0;
			for (int j = 0; j < a.length; j++) {
				total += a[j]*b[i+j];
			}
			if(max < total) {
				max = total;
			}
		}
		
	System.out.println(max);
		
		
	}
}
