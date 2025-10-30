import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		char[] standard = br.readLine().trim().toCharArray();

		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().trim().toCharArray();

			if (check(standard, temp)) {
				System.out.println("DA");
			} else {
				System.out.println("NE");
			}
		}

	}

	private static boolean check(char[] standard, char[] temp) {
	    // *의 위치 찾기
	    int starPos = 0;
	    for (int j = 0; j < standard.length; j++) {
	        if (standard[j] == '*') {
	            starPos = j;
	            break;
	        }
	    }
	    
	    int prefixLen = starPos;
	    int suffixLen = standard.length - starPos - 1;
	    
	    // 길이 체크: 겹침 방지!
	    if (temp.length < prefixLen + suffixLen) {
	        return false;
	    }
	    
	    // 앞에서부터 검사
	    int i = 0;
	    while (standard[i] != '*') {
	        if (standard[i] != temp[i]) {
	            return false;
	        }
	        i++;
	    }
	    
	    // 뒤에서부터 검사
	    int sL = standard.length;
	    int tL = temp.length;
	    i = 1;
	    
	    while (standard[sL - i] != '*') {
	        if (standard[sL - i] != temp[tL - i]) {
	            return false;
	        }
	        i++;
	    }
	    
	    return true;
	}

}
