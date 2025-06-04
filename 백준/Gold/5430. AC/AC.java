import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= T; tc++) {
			char[] P = br.readLine().trim().toCharArray();
			Deque<String> queue = new ArrayDeque<>();
			boolean reverse = false;
			
			int n = Integer.parseInt(br.readLine().trim());
			
			StringTokenizer st = new StringTokenizer(br.readLine().trim(),"[,]");
			while (st.hasMoreTokens()) {
				queue.offer(st.nextToken());
			}
			
			boolean isError = false;
			for (int i = 0; i < P.length; i++) {
				if(P[i]=='R') {
					reverse = !reverse;
				}else {
					if(queue.size()==0) {
						isError = true;
						break;
					}
					if(reverse) {
						queue.pollLast();
					}else {
						queue.pollFirst();
					}
				}
			}
			
			if(isError) {
				sb.append("error");
			}else {
				int size = queue.size();
				sb.append("[");
				if(queue.size()>0) {
					if(reverse) {
						for (int i = 0; i < size; i++) {
							sb.append(queue.pollLast()+",");
						}
						sb.deleteCharAt(sb.length()-1);
					}else {
						for (int i = 0; i < size; i++) {
							sb.append(queue.pollFirst()+",");
						}
						sb.deleteCharAt(sb.length()-1);
					}
				}
				sb.append("]");
			}
			
			sb.append("\n");
		} // tc
		System.out.print(sb);
	}


}

