
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim());
			
			int[] student = new int[N+1];
			boolean[] visited = new boolean[N+1];	//0번 인덱스는 버리기 
			String[] temp = br.readLine().trim().split(" ");
			int teamNum = 0;
			
			for (int i = 0; i < N; i++) {
				student[i+1] = Integer.parseInt(temp[i]);
				if(i+1 == student[i+1]) {
					//1인 팀 완성 
					teamNum++;
					visited[i+1] = true;
				}
			}
			//입력 완료
			
			
			for (int i = 1; i <= N; i++) {
				if(!visited[i]) {
					int start = i;
					int idx = 0;
					List<Integer> list = new ArrayList<>();
					Map<Integer, Integer> map = new HashMap<>();
					while (true) {
						if(!visited[start]) {
							visited[start] = true;
							map.put(start, idx++);
//							list.add(start);
							int next = student[start];
							if(map.containsKey(next)) {
								//팀 완성되는 겨우가 존재
								//next와 동일한 시작점을 찾아야 함
								teamNum += map.size()-map.get(next);
								break;
							}else {
								start = next;
								continue;
							}
							
						}else {
//							for (int j = 1; j < list.size(); j++) {
//								visited[list.get(j)] = false;
//							}
							break;
						}
						
					}
					
				}
				
				
			}
			int res = N-teamNum;
			
			System.out.println(res);
			
			
		}//tc
	}
	
}


