import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine().trim());
		
		int mock = N/4;
		
		for(int i=0; i<mock-1; i++) {
			sb.append("long ");
		}
		
		sb.append("long int");

		System.out.println(sb);

	}

}
