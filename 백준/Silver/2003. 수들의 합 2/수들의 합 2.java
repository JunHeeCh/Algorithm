
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().trim().split(" ");
		int N = Integer.parseInt(nm[0]);
		int M = Integer.parseInt(nm[1]);
		
		int[] num = new int[N];
		
		String[] temp = br.readLine().trim().split(" ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(temp[i]);
		}
		
		//입력 완
		int count = 0;
		
		int sum;
		
		for (int i = 0; i < num.length; i++) {	//시작 지점(1개 짜리도 포함)
			
			sum = 0;
			
			for (int j = i; j < num.length; j++) {
				sum += num[j];
				if(sum == M)
					count++;
			}
		}
		
		System.out.println(count);
		
		
	}

}
