
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			char[] temp = br.readLine().trim().toCharArray();
			int res = 0;
			int count = 0;
			for (int j = 0; j < temp.length; j++) {
				if(temp[j]=='O') {
					count++;
					res += count;
				}else {
					count = 0;
				}
			}
			sb.append(res+"\n");
		}
		System.out.println(sb);
	}
}
