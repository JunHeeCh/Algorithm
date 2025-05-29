import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		PriorityQueue<person> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			String[] temp = br.readLine().trim().split(" ");
			int a = Integer.parseInt(temp[0]);
			
			pq.add(new person(i, a, temp[1]));
		}
		
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}

	static class person implements Comparable<person>{
		int idx;
		int age ;
		String name;
		
		private person(int idx, int age, String name) {
			this.idx = idx;
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(person o) {
			if(this.age == o.age) {
				return Integer.compare(this.idx, o.idx);
			}
			return Integer.compare(this.age, o.age);
		}

		@Override
		public String toString() {
			return age + " " + name;
		}
		
		
	}
}
