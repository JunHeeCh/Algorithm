import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] score = new int[8];
		int[] copy = new int[8];
		
		for (int i = 0; i < score.length; i++) {
			score[i] = Integer.parseInt(br.readLine().trim());
			copy[i] = score[i];
		}
		
		Arrays.sort(copy);
		
		int standard = copy[2];
		
		int res = 0;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < score.length; i++) {
			if(score[i] > standard) {
				sb.append((i+1)+" ");
				res += score[i];
			}
		}

		System.out.println(res);
		System.out.println(sb);
	}

}
