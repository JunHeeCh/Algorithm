import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] temp = br.readLine().trim().split(" ");

		int a = Integer.parseInt(temp[0]);
		int b = Integer.parseInt(temp[1]);
		int c = Integer.parseInt(temp[2]);

		System.out.print(cal(a, b, c));

	}

	private static long cal(int a, int b, int c) {
		if (b == 1)
			return a % c;

		long half = cal(a, b / 2, c);

		if (b % 2 == 0) {
			return (half * half) % c;
		} else {
			return (half * half % c) * a % c;
		}
	}

}
