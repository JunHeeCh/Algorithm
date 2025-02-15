import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		int[][] arr = new int[N+1][N+1];
		for (int i = 1; i < N+1; i++) {
			NM = br.readLine().split(" ");
			for (int j = 1; j < N+1; j++) {
				arr[i][j] = arr[i][j-1] + Integer.parseInt(NM[j-1]);
			}
		}//보드 판 저장
		
		for (int i = 0; i < M; i++) {	//시작과 끝 4개 요소가 M번 들어옴
			NM = br.readLine().split(" ");
			int x1 = Integer.parseInt(NM[0]);
			int y1 = Integer.parseInt(NM[1]);
			int x2 = Integer.parseInt(NM[2]);
			int y2 = Integer.parseInt(NM[3]);
			int sum = 0;
			///여기까지는 입력 받은 것(인덱스 기준으로)
			for (int j =x1; j <= x2; j++) {
				sum += arr[j][y2]-arr[j][y1-1];
			}
			
			bw.write(sum+"\n");
	
		}
		bw.flush();
	}
}
