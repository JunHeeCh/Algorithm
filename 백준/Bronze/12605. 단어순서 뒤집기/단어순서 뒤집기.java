import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();

		int num = Integer.parseInt(br.readLine().trim());
		
		for (int i = 0; i < num; i++) {
			sb.append("Case #"+(i+1)+": ");
			String[] temp = br.readLine().trim().split(" ");
			for (int j = temp.length-1; j >= 0 ; j--) {
				sb.append(temp[j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
