import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] curr = br.readLine().trim().split(" ");
		float[] current = new float[2];
		current[0] = Float.parseFloat(curr[0]);
		current[1] = Float.parseFloat(curr[1]);

		String[] des = br.readLine().trim().split(" ");
		float[] destination = new float[2];
		destination[0] = Float.parseFloat(des[0]);
		destination[1] = Float.parseFloat(des[1]);

		int N = Integer.parseInt(br.readLine().trim());

		float[][] data = new float[N+2][2];
		for (int i = 0; i < N; i++) {
			String[] cann = br.readLine().trim().split(" ");
			data[i+1][0] = Float.parseFloat(cann[0]);
			data[i+1][1] = Float.parseFloat(cann[1]);
		}
		
		data[0][0] =  current[0];
		data[0][1] =  current[1];
		data[N+1][0] = destination[0];
		data[N+1][1] = destination[1];

		// 시간 계산

		float[] time = new float[N + 2]; // 대포까지의 거리 + 목적지까지의 거리
		boolean[] visited = new boolean[N+2];

		PriorityQueue<destiny> pq = new PriorityQueue<>();
		for (int i = 1; i < time.length; i++) {
			time[i]= clacwalk(data[0][0], data[0][1], data[i][0], data[i][1]);
			pq.add(new destiny(i,data[i][0], data[i][1], time[i]));
		}
		
		
		
		while (!pq.isEmpty()) {
			destiny now = pq.poll();
			
			if(now.idx==N+1) break;
			
			if(visited[now.idx]) continue;
			visited[now.idx] = true;
			
			for (int i = 1; i < time.length; i++) {
				if(!visited[i]) {
					float walk = clacwalk(now.x, now.y, data[i][0], data[i][1]);
					float fly = claccann(now.x, now.y, data[i][0], data[i][1]);
					float mini = Math.min(walk, fly);
					
					if(time[now.idx]+mini < time[i]) {
						time[i] = time[now.idx]+mini;
						pq.add(new destiny(i, data[i][0], data[i][1], time[i]));
					}
				}
			}
		}//while
		
		System.out.println(time[N+1]);
		

	}// main


	static float clacwalk(float sx, float sy, float ex, float ey) {
		float difx = sx - ex;
		float dify = sy - ey;
		double dis = Math.sqrt(difx * difx + dify * dify);

		return (float) (dis / 5);
	}

	static float claccann(float sx, float sy, float ex, float ey) {
		float difx = sx - ex;
		float dify = sy - ey;
		double dis = Math.sqrt(difx * difx + dify * dify);

		return (float) (2 + (Math.abs(dis - 50) / 5));

	}
}

class destiny implements Comparable<destiny>{
	int idx;
	float x,y;
	float cost;
	
	public destiny(int idx, float x, float y, float cost) {
		this.idx = idx;
		this.x = x;
		this.y = y;
		this.cost = cost;
	}

	@Override
	public int compareTo(destiny o) {
		return Float.compare(this.cost, o.cost);
	}
	
	
}
