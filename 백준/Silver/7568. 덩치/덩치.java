import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		person[] p = new person[N];

		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().trim().split(" ");
			p[i] = new person(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
		}

		for (int i = 0; i < p.length; i++) {
			int res = 0;
			for (int j = 0; j < p.length; j++) {
				if(i == j) continue;
				if(p[i].weight < p[j].weight && p[i].height < p[j].height) {
					res++;
				}
			}
			System.out.print(res+1+" ");
		}

	}

}

class person {
	int weight;
	int height;

	public person(int weight, int height) {
		this.weight = weight;
		this.height = height;
	}

}
