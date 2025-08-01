import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim(), ":");

		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int time = m * 60 + s; //초단위 조리시간
		time /= 10;
		
		int[] arr = new int[time+61];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 1;
		
		System.out.println(findArr(arr, time));
	}

	private static int findArr(int[] arr, int i) {
		if(i < 0) {
			return Integer.MAX_VALUE;
		}
		if(i==0) {
			return arr[0];
		}
		
		if(arr[i] == 0) {
			arr[i] = Math.min(Math.min(findArr(arr, i-1), findArr(arr, i-3)), Math.min(findArr(arr, i-6), findArr(arr, i-60)))+1;					
		}
		
		return arr[i];
	}

}
