import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x = Integer.parseInt(br.readLine().trim());

		int[][] board = new int[x][x];
		
		String[] temp;
		for (int i = 0; i < x; i++) {
			temp = br.readLine().trim().split(" ");
			for (int j = 0; j < temp.length; j++) {
				board[i][j] = Integer.parseInt(temp[j]);
			}
		}

		int[][] right = new int[x][x];
		int[][] down = new int[x][x];
		int[][] res = new int[x][x];
		
		for (int i = 0; i < right.length; i++) {
			for (int j = 1; j < right[0].length; j++) {
				right[i][j] = (board[i][j]<board[i][j-1])?0:board[i][j]+1-board[i][j-1];
			}
		}
		
		for (int i = 1; i < down.length; i++) {
			for (int j = 0; j < down[0].length; j++) {
				down[i][j] = (board[i][j]<board[i-1][j])?0:board[i][j]+1-board[i-1][j];
			}
		}
		
		for (int i = 1; i < res.length; i++) {
			res[0][i] = res[0][i-1]+right[0][i];
			res[i][0] = res[i-1][0]+down[i][0];
		}
		
		for (int i = 1; i < res.length; i++) {
			for (int j = 1; j < res[0].length; j++) {
				res[i][j] = Math.min(res[i-1][j]+down[i][j], res[i][j-1]+right[i][j]);
			}
		}

		System.out.println(res[x-1][x-1]);

	}

}
