
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 
		int N = Integer.parseInt(br.readLine());	//수의 개수
		int[] A = new int[N];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(input[i]);
		}

		int M = Integer.parseInt(br.readLine()); 	//구간의 개수
		int[][] subpart = new int[M][2];	
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			subpart[i][0] = Integer.parseInt(input[0]); //-1하면 구간합의 시작 인덱스
			subpart[i][1] = Integer.parseInt(input[1]);	//-1하면 구간합의 마지막 인덱스(포함하기)
		}
		
		int first = 0;
		int last = 0;
		for (int i = 0; i < M; i++) {
			int sum = 0;
			first = subpart[i][0]-1;	//구간합의 시작
			last = subpart[i][1]-1;	//구간합의 마지막
			for (; first <= last; first++) {
				sum += A[first];
			}
			bw.write(sum+"\n");
		}
		bw.flush();
	}
}
