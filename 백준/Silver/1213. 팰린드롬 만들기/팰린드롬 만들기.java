import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] alphabet = br.readLine().trim().toCharArray();

		int[] alpha = new int[26];
		for (int i = 0; i < alphabet.length; i++) {
			alpha[alphabet[i] - 'A']++;
		}

		int cntOdd = -1;

		for (int i = 0; i < alpha.length; i++) {
			if (alpha[i] % 2 != 0 && cntOdd == -1) {
				cntOdd = i;
			} else if (alpha[i] % 2 != 0 && cntOdd != -1) {
				System.out.println("I'm Sorry Hansoo");
				return;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < alpha.length; i++) {
			if(alpha[i] > 0) {
				for (int j = 0; j < alpha[i]/2; j++) {
					sb.append((char)(i+'A'));
				}
			}
		}
		
		StringBuilder sb2 = new StringBuilder(sb);
		sb2.reverse();
		
		if(cntOdd != -1) {
			sb.append((char)(cntOdd+'A')).append(sb2);			
		}else {
			sb.append(sb2);
		}

		
		System.out.println(sb);
	}

}
