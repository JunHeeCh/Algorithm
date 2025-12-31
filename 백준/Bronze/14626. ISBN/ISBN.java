import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] num = br.readLine().trim().toCharArray();
		
		int sum = 0;
		int multi = 0;
		for(int i=0; i<num.length; i++) {
			if(num[i]=='*') {
				multi = i%2==0?1:3;
				continue;
			}
			sum += (num[i]-'0')*(i%2==0?1:3);
		}

//		sum + multi*x = 10의 배수
		for(int i=0; i<10; i++) {
			if((sum+multi*i)%10==0) {
				System.out.print(i);
				return;
			}
		}

	}

}
