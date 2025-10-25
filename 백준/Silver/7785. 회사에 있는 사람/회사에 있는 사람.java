import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());
		
		Set<String> set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().trim().split(" ");
			if(temp[1].equals("enter")) {
				set.add(temp[0]);
			}else {
				set.remove(temp[0]);
			}
		}
		
		String[] arr = new String[set.size()];
		int idx = 0;
		for (String st : set) {
			arr[idx++] = st;
		}
		
		Arrays.sort(arr);
		
		for (int i = arr.length-1; i >= 0; i--) {
			System.out.println(arr[i]);			
		}

	}

}
