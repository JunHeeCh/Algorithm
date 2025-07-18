import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		
		int one = Integer.MAX_VALUE;
		int six = Integer.MAX_VALUE;
		
		for (int i = 0; i < M; i++) {
			temp = br.readLine().trim().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			
			one = Math.min(one, b);
			six = Math.min(six, a);
		}

		int moc = N/6;
		int rest = N%6;
		
		int total = 0;
		total += moc*Math.min(six, one*6);
		total += Math.min(six, rest*one);
		
		System.out.println(total);
	}
}