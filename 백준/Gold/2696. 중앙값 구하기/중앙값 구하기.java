
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

//2696
public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb= new StringBuilder();
		
		for (int tc = 1; tc <= T; tc++) {
//			PriorityQueue<Integer> pq = new PriorityQueue<>();

			int cnt = 0;
			List<Integer> list = new LinkedList<>();
			
			
			int M = Integer.parseInt(br.readLine().trim());
			int total = (M/2)+1;
			sb.append(total + "\n");
			int[] nums = new int[M];
			
			for (int i = 0; i <= (M-1)/10; i++) {
				
				String[] temp = br.readLine().trim().split(" ");
				for (int j = 0; j < temp.length; j++) {
					nums[i*10+j]=Integer.parseInt(temp[j]);
					addList(list, nums[i*10+j]);
					if(j%2==0) {
						//출력하기 
						sb.append(list.get((list.size()/2))+" ");
						cnt++;
						if(cnt == 10) {
							sb.append("\n");
							cnt = 0;
						}
					}
				}
				
			}
			sb.append("\n");
		}//tc
		System.out.println(sb);
	}

	private static void addList(List<Integer> list, int num) {
		int start = 0;
		int end = list.size();
		
		while (start<end) {
			int mid = (start+end)/2;
			if(list.get(mid)<num) {
				start = mid+1;
			}else {
				end = mid;
			}
			
		}
		list.add(start, num);
	}
}


