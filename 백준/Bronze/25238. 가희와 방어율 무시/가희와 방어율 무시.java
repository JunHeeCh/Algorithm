import java.util.*;
import java.io.*;

public class Main {

	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");
		int a = Integer.parseInt(temp[0]);
		int b = Integer.parseInt(temp[1]);

		if (a * (100 - b) / 100 >= 100) {
			System.out.println(0);
		} else {
			System.out.println(1);
		}

	}

}
