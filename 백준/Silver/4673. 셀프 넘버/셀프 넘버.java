import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean[] visited = new boolean[10001];

		for (int i = 1; i < 10000; i++) {
			func(visited, i);
		}

		for (int i = 1; i < visited.length; i++) {
			if (!visited[i])
				System.out.println(i);
		}
	}

	private static void func(boolean[] visited, int i) {

		if (i >= visited.length) {
			return;
		}

		int num = i;
		while (i > 0) {
			num += i % 10;
			i /= 10;
		}

		if (num >= visited.length || visited[num])
			return;
		visited[num] = true;
		func(visited, num);
	}

}
