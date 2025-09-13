import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		
		String[] arr = new String[5];

		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().trim().split(" ");
			int hard = Integer.parseInt(temp[1]);
			arr[hard] = temp[0];
		}
		
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]!=null) {
				System.out.println(arr[i]);
				break;
			}
		}

	}


}
