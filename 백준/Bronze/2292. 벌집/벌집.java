import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		int time = 1;
		int standard = 1;

		while(true) {
			if(N <=standard){
				System.out.println(time);
				break;
			}
			standard+= 6*time;
			time++;
		}
		
	}

}
