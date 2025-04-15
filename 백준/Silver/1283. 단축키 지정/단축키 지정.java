import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());

		Set<Character> set = new HashSet<>();
		int[] loc = new int[N];
		
		Arrays.fill(loc, 100);
		
		int length = 0;
		
		words: 
		for (int i = 0; i < N; i++) {
			String temp = br.readLine().trim();	//검사할 단어
			String[] divide = temp.split(" ");	//각 단어의 첫글자 검사하기
			char[] tmp = temp.toCharArray();
			length = 0;
			
			for (int j = 0; j < divide.length; j++) { // 1번 조건
				char one = divide[j].charAt(0);
				if (set.contains(one)) {
					length+= divide[j].length()+1;
					continue;
				}else {
					loc[i] = length;
					if(tmp[length] >= 65 && tmp[length] <= 90) {
						set.add((char)(one+32));
					}else {
						set.add((char)(one-32));
					}
					set.add(one);
					for (int k = 0; k < tmp.length; k++) {
						if(k==length) {
							System.out.print("["+tmp[k]+"]");
						}else {
							System.out.print(tmp[k]);
						}
					}
					System.out.println();
					continue words;
				}
				
			}
			
			//2번 조건
			for (int j = 0; j < tmp.length; j++) {
				if(tmp[j] == ' ') continue;
				if(set.contains(tmp[j])) {
					continue;
				}else {
					set.add(tmp[j]);
					if(tmp[j] >= 65 && tmp[j] <= 90) {
						set.add((char)(tmp[j]+32));
					}else {
						set.add((char)(tmp[j]-32));
					}
					loc[i] = j;
					for (int k = 0; k < tmp.length; k++) {
						if(k==j) {
							System.out.print("["+tmp[k]+"]");
						}else {
							System.out.print(tmp[k]);
						}
					}
					System.out.println();
					continue words;
				}
			}
			
			//3번 조건
			System.out.println(temp);

		}
		
		
		
		
	}
}
