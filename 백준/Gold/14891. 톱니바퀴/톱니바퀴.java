import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		LinkedList<Character>[] list = new LinkedList[5];
		for (int i = 0; i < list.length; i++) {
			list[i] = new LinkedList<>();
		}

		for (int i = 1; i < list.length; i++) {
			char[] temp = br.readLine().trim().toCharArray();
			for (int j = 0; j < temp.length; j++) {
				list[i].add(temp[j]);
			}
		}
		
		int K = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < K; i++) {
			String[] tmp = br.readLine().trim().split(" ");
			int a = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[1]);
			
			move(list, a,b);
		}
		
		int sum = 0;
		for (int i = 1; i < list.length; i++) {
			if(list[i].get(0) == '1') {
				sum += Math.pow(2, i-1);
			}
		}

		System.out.println(sum);

	}

	private static void move(LinkedList<Character>[] list, int num, int dir) {
		boolean[] visited = new boolean[5];
		
		List<int[]> change = new ArrayList<>();
		change.add(new int[] {num, dir});
		visited[num] = true;
		
		// 양 옆의 바퀴와 방향이 다른지를 확인해보기
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {num, dir});
		
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int rear = now[0]-1;
			int drive = now[0]+1;
			
			if(rear >= 1 && !visited[rear]) {
				// 왼쪽 존재 
				if(list[rear].get(2) != list[now[0]].get(6)) {
					change.add(new int[] {rear, now[1]*(-1)});
					visited[rear] = true;
					queue.add(new int[] {rear, now[1]*(-1)});
				}
			}
			
			if(drive <= 4 && !visited[drive]) {
				// 오른쪽 존재 
				if(list[drive].get(6) != list[now[0]].get(2)) {
					change.add(new int[] {drive, now[1]*(-1)});
					visited[drive] = true;
					queue.add(new int[] {drive, now[1]*(-1)});
				}
			}
			
		}
		
		changeList(list, change);
		
	}

	private static void changeList(LinkedList<Character>[] list, List<int[]> change) {
		for (int[] now : change) {
			int num = now[0];
			int dir = now[1];
			
			if(dir==1) {
				char temp =list[num].remove(list[num].size()-1);
				list[num].addFirst(temp);
			}else {
				char temp =list[num].remove(0);
				list[num].addLast(temp);
			}
		}
		
	}

}
