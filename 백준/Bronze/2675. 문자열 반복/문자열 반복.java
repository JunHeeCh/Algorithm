import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		int tc = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < tc; i++) {
			String[] temp = br.readLine().trim().split(" ");
			int num = Integer.parseInt(temp[0]);
			
			char[] st = temp[1].toCharArray();
			
			for (int j = 0; j < st.length; j++) {
				for (int k = 0; k < num; k++) {
					sb.append(st[j]);
				}
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
