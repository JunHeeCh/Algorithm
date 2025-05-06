import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String[] temp = br.readLine().trim().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			int c = Integer.parseInt(temp[2]);
			
			if(a+b+c==0) {
				break;
			}
			
			int max = Math.max(a, Math.max(b, c));
			
			if(a*a+b*b+c*c == max*max*2) {
				System.out.println("right");
			}else {
				System.out.println("wrong");
			}
		}
		
	}

}
