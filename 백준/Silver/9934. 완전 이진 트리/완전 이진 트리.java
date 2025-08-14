import java.util.*;
import java.io.*;

public class Main {

	static int[] order;
	static int idx = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine().trim());
		int N = (int) Math.pow(2, K);
		N--;
		
		int[] num = new int[N];
		order = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer>[] list = new ArrayList[K];
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		// 중위순회 
		
		middle(1, N);
		
		for (int i = 0; i < num.length; i++) {
			int a =(int) (Math.log(order[i])/Math.log(2));
			list[a].add(num[i]);
		}
		
		for (int i = 0; i < list.length; i++) {
			for (Integer number : list[i]) {
				sb.append(number+" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}

	private static void middle(int i, int n) {
		if(i > n) return;
		middle(i*2, n);
		order[idx++] = i;
		middle(i*2+1, n);
	}

}
