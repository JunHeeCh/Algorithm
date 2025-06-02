import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Deque<Character> q1 = new ArrayDeque<>();
		Deque<Character> q2 = new ArrayDeque<>();

		char[] first = br.readLine().trim().toCharArray();
		
		for (int i = 0; i < first.length; i++) {
			q1.add(first[i]);
		}
		
		int M = Integer.parseInt(br.readLine().trim());
		
		for (int i = 0; i < M; i++) {
			char[] cmd = br.readLine().trim().toCharArray();
			if(cmd[0]=='L') {
				if(q1.size()!=0) {
					q2.addFirst(q1.pollLast());
				}
			}else if(cmd[0]=='D') {
				if(q2.size()!=0) {
					q1.addLast(q2.pollFirst());
				}
			}else if(cmd[0]=='B') {
				if(q1.size()!=0) {
					q1.pollLast();
				}
			}else if(cmd[0]=='P') {
				q1.addLast(cmd[2]);
			}
		}
		int s1 = q1.size();
		int s2 = q2.size();
		for (int i = 0; i < s1; i++) {
			sb.append(q1.pollFirst());
		}
		for (int i = 0; i < s2; i++) {
			sb.append(q2.pollFirst());
		}
		
		System.out.println(sb);
	}
}
