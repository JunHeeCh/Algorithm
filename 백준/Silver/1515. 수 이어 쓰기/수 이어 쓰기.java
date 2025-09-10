import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] num = br.readLine().trim().toCharArray();
		
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < num.length; i++) {
			list.add(num[i]);
		}
		
		int res = 1;
		
		while(!list.isEmpty()) {
			check(list, res);
			res++;
		}
		

		System.out.println(res-1);

	}

	private static void check(List<Character> list, int res) {
		char[] temp = String.valueOf(res).toCharArray();
		
		for (int i = 0; i < temp.length; i++) {
			if(!list.isEmpty()&&temp[i] == list.get(0)) {
				list.remove(0);
			}
		}
		
	}

}
