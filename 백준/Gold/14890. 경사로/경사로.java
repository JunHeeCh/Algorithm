import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().trim().split(" ");

		int N = Integer.parseInt(temp[0]);
		int L = Integer.parseInt(temp[1]);

		int[][] board = new int[N][N];
		int res = 0;

		for (int i = 0; i < board.length; i++) {
			temp = br.readLine().trim().split(" ");
			for (int j = 0; j < board.length; j++) {
				board[i][j] = Integer.parseInt(temp[j]);
			}
		}

		// 가로 길
		for (int i = 0; i < board.length; i++) {
			int prev = board[i][0];
			int contin = 1;
			boolean isSuccess = true;

			int j = 1;
			while (j < N) {
				if (board[i][j] == prev) { // 계속 일관된 높이
					contin++;
					j++;
					continue;
				}
				if (Math.abs(board[i][j] - prev) > 1) { // 높이 차이가 1
					isSuccess = false;
					break;
				}
				
				if(board[i][j] > prev) {
					// 오르막 -> 이전에 
					if (contin < L) {
						isSuccess = false;
						break;
					}
					prev = board[i][j];
					contin = 1;
					j++;
					continue;
				}else {
					// 내리막 -> 이후에 
					// 이 이후 L 칸동안 길이가 동일해야 함
					for (int k = j; k < j + L; k++) {
						if (k >= N || board[i][k] != board[i][j]) {
							isSuccess = false;
							break;
						}
					}
					if (!isSuccess) {
						break;
					}
					prev = board[i][j];
					j += L;
					contin = 0;
					continue;
				}

			}

			if (isSuccess) {
				res++;
			}
		}

		// 세로 길
		for (int j = 0; j < board[0].length; j++) {
			int prev = board[0][j];
			int contin = 1;
			boolean isSuccess = true;

			int i = 1;
			while (i < N) {
				if (board[i][j] == prev) { // 계속 일관된 높이
					contin++;
					i++;
					continue;
				}
				if (Math.abs(board[i][j] - prev) > 1) { // 높이 차이가 1
					isSuccess = false;
					break;
				}
				
				if(board[i][j] > prev) {
					// 오르막 -> 이전에 
					if (contin < L) {
						isSuccess = false;
						break;
					}
					prev = board[i][j];
					contin = 1;
					i++;
					continue;
				}else {
					// 내리막 -> 이후에 
					// 이 이후 L 칸동안 길이가 동일해야 함
					for (int k = i; k < i + L; k++) {
						if (k >= N || board[k][j] != board[i][j]) {
							isSuccess = false;
							break;
						}
					}
					if (!isSuccess) {
						break;
					}
					prev = board[i][j];
					i += L;
					contin = 0;
					continue;
				}
			}

			if (isSuccess) {
				res++;
			}
		}

		System.out.println(res);
	}

}
