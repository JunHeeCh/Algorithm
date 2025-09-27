import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] temp = br.readLine().trim().split(" ");

		long r = Long.parseLong(temp[0]);
		long c = Long.parseLong(temp[1]);
		int n = Integer.parseInt(temp[2]);

		if (r % n == 0) {
			r /= n;
		} else {
			r /= n;
			r++;
		}

		if (c % n == 0) {
			c /= n;
		} else {
			c /= n;
			c++;
		}

		System.out.println(r * c);

	}

}
