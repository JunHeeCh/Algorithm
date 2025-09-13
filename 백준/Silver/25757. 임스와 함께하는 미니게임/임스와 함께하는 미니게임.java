import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().trim().split(" ");
		int N = Integer.parseInt(temp[0]);
		
		// temp[1] 이 플레이하기 원하는 게임
		int people = 0;
		
		if(temp[1].equals("Y")) {
			people = 1;
		}else if(temp[1].equals("F")) {
			people = 2;
		}else {
			people = 3;
		}
		
		Set<String> set = new HashSet<>();
		int cnt = 0;
		int res = 0;
		
		for (int i = 0; i < N; i++) {
			String name = br.readLine().trim();
			if(set.contains(name)) continue;
			
			cnt++;
			set.add(name);
			
			if(cnt == people) {
				res++;
				cnt = 0;
			}
		}
		
		System.out.println(res);

	}


}
