import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] origin = new int[26];
		int originL = 0;

		int N = Integer.parseInt(br.readLine().trim());

		char[] temp = br.readLine().trim().toCharArray();

		originL = temp.length;
		for (int i = 0; i < temp.length; i++) {
			origin[temp[i] - 'A']++;
		}

		int res = 0;

		for (int i = 0; i < N - 1; i++) {
			int[] compare = new int[26];
			int compareL = 0;

			temp = br.readLine().trim().toCharArray();
			compareL = temp.length;

			for (int j = 0; j < temp.length; j++) {
				compare[temp[j] - 'A']++;
			}

			if (originL == compareL) {
				// 모두 동일하거나, 한 글자가 다르거나만 허용
				int flag = 0;
				boolean impossible = false;
				
				for (int j = 0; j < compare.length; j++) {
					if (origin[j] != compare[j]) {
						int diff = Math.abs(origin[j]-compare[j]);
						
						if(diff > 1) {
							// 불가 
							impossible = true;
							break;
						}else{
							// 차이가 1인 경우 
							if(flag == 0) {
								flag = 1;								
							}else if(flag == 1) {
								flag = 2;
							}else {
								// 불가 
								impossible = true;
								break;
							}
						}
					}
				}
				
				if(!impossible) {
					res++;
				}
				
			} else {
				// 한 문자가 추가된 경우만 인정 
				int cnt = 0;
				boolean impossible = false;
				
				for (int j = 0; j < compare.length; j++) {
					if (origin[j] != compare[j]) {
						cnt += Math.abs(origin[j]-compare[j]);
						
						if(cnt >1) {
							impossible = true;
							break;
						}
						
					}
				}
				
				if(!impossible) {
					res++;
				}
			}

		}

		System.out.println(res);

	}
}
