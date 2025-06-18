import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//1931 
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine().trim());

		meeting[] arr = new meeting[N];

		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().trim().split(" ");
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			arr[i] = new meeting(a, b);
		}
		
		Arrays.sort(arr);
		int endTime = 0;
		int res = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].start >= endTime) {
				res++;
				endTime = arr[i].end;
			}
		}

		
		System.out.println(res);
	}
}

class meeting implements Comparable<meeting>{
	int start;
	int end;

	public meeting(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
public int compareTo(meeting o) {
    if (this.end != o.end) {
        return Integer.compare(this.end, o.end);  // 끝나는 시간 우선
    }
    return Integer.compare(this.start, o.start);  // 끝나는 시간 같으면 시작 시간
}
	
}
