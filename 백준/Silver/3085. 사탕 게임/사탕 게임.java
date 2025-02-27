import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] board = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < N; j++) {
				board[i][j] = tmp.charAt(j);
			}
		}
		
		//가장 긴 길이는 N
		//위치 변경 후 함수 사용하기
		int length = 0;
		int max = 0;
//		char[][] copied = new char[N][N];
//		
//		for (int i = 0; i < copied.length; i++) {
//			for (int j = 0; j < copied.length; j++) {
//				copied[i][j] = board[i][j];
//			}
//		}
		
		outter:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N-1; j++) {
				
				int[] ij = {i,j};
				int[] nextij = {i,j+1};
				length = longest(board,ij,nextij);
				max = Math.max(max, length);
				if(length == N) {
					break outter;
				}
				
				ij[0] = j;
				ij[1] = i;
				nextij[0] = j+1;
				nextij[1] = i;
				length = longest(board,ij,nextij);
				max = Math.max(max, length);
				if(length == N) {
					break outter;
				}
				
				
			}
		}
		
		System.out.println(max);
		
		
	}
	
	
	public static int longest(char[][] board, int[] ij, int[] nextij) {
		//가장 긴 길이 찾기
		char temp = board[ij[0]][ij[1]];
		board[ij[0]][ij[1]] = board[nextij[0]][nextij[1]];
		board[nextij[0]][nextij[1]] = temp;
		//가로 탐색
		char tmp;
		int max = 0;
		
		//세로 탐색 
		char verticalTmp;
		int verMax = 0;
		
		for (int i = 0; i < board.length; i++) {
			int cnt = 1;
			tmp = board[i][0];
			
			int cntV = 1;
			verticalTmp = board[0][i];
			for (int j = 1; j < board.length; j++) {
				if(tmp == board[i][j]) {
					cnt++;
					max = Math.max(max, cnt);
				}else {
					tmp = board[i][j];
					cnt = 1;
				}
				if(verticalTmp == board[j][i]) {
					cntV++;
					verMax = Math.max(verMax, cntV);
				}else {
					verticalTmp = board[j][i];
					cntV = 1;
				}
			}
		}
		temp = board[ij[0]][ij[1]];
		board[ij[0]][ij[1]] = board[nextij[0]][nextij[1]];
		board[nextij[0]][nextij[1]] = temp;
		
		return Math.max(verMax, max);
	}
}
