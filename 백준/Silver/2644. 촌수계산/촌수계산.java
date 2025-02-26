import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		String[] find = br.readLine().trim().split(" ");
		int finda = Integer.parseInt(find[0]);
		int findb = Integer.parseInt(find[1]);
		int m = Integer.parseInt(br.readLine().trim());
		List<Integer>[] graph = new ArrayList[N+1];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			String[] fam = br.readLine().trim().split(" ");
			int p = Integer.parseInt(fam[0]);
			int ch = Integer.parseInt(fam[1]);
			graph[p].add(ch);
		}
		
		System.out.println(bfs(graph, finda, findb));
		
	}
	
	public static int bfs(List<Integer>[] graph, int a, int b) {
		//공통 부모 찾기
		List<Integer> parentsA = new ArrayList<>();
		parentsA.add(a);
		findP(graph, a, parentsA);
		List<Integer> parentsB = new ArrayList<>();
		parentsB.add(b);
		findP(graph, b, parentsB);
		int asize = parentsA.size();
		int bsize = parentsB.size();
		int min = Math.min(asize, bsize);
		
		if(parentsA.get(parentsA.size()-1) == parentsB.get(parentsB.size()-1)) {
			for (int i = 0; i < min; i++) {
				if(parentsA.get(parentsA.size()-1) == parentsB.get(parentsB.size()-1)) {
					parentsA.remove(parentsA.get(parentsA.size()-1));
					parentsB.remove(parentsB.get(parentsB.size()-1));
				}else {
					break;
				}
			}
			int res = parentsA.size()+parentsB.size();
			
			return res;
		}
		
		return -1;
	}
	
	
	public static void findP(List<Integer>[] graph, int num, List<Integer> parents) {
		for (int i = 0; i < graph.length; i++) {
			if(graph[i].contains(num)) {
				parents.add(i);
				findP(graph, i, parents);
			}
		}
	}
}
