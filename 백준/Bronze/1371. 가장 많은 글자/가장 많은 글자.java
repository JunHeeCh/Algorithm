import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[26];
		
		while(true) {
			String sent = br.readLine();
			if(sent == null) break;
			
			StringTokenizer st = new StringTokenizer(sent);
			while(st.hasMoreTokens()) {
				char[] temp = st.nextToken().toCharArray();
				for(int i=0; i<temp.length; i++) {
					arr[temp[i]-'a']++;
				}
			}
		}
		

		StringBuilder sb = new StringBuilder();
		int max = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>max) {
				sb = new StringBuilder();
				sb.append((char) ('a' + i));
				max = arr[i];
			}else if(arr[i]==max) {
				sb.append((char) ('a' + i));				
			}
		}
		
		System.out.println(sb);

	}

}
