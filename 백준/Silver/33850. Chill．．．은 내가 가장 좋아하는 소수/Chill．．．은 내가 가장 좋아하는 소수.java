import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int a; // 소수인 경우 점수
    static int b; // 소수가 아닌 경우 점수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().trim().split(" ");

        int n = Integer.parseInt(temp[0]);
        a = Integer.parseInt(temp[1]); // 소수인 경우 점수
        b = Integer.parseInt(temp[2]); // 소수가 아닌 경우 점수

        int[][] board = new int[2][n];
        for (int i = 0; i < board.length; i++) {
            temp = br.readLine().trim().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(temp[j]);
            }
        }
        // 입력 완료

        int[] total = new int[n];
        Arrays.fill(total, Integer.MIN_VALUE);
        
        int sum0 = board[0][0] + board[1][0];
        if (isPrime(sum0)) {
            total[0] = a; // 소수인 경우 a점
        } else {
            total[0] = b; // 소수가 아닌 경우 b점
        }
        
        if (n > 1) {
            int compare0 = total[0];
            int compare1 = 0;
            
            // 세로 타일 방식
            int col1 = board[0][1] + board[1][1];
            if (isPrime(col1)) {
                compare0 += a; // 소수인 경우 a점
            } else {
                compare0 += b; // 소수가 아닌 경우 b점
            }
            
            // 가로 타일 방식
            int row0 = board[0][0] + board[0][1];
            int row1 = board[1][0] + board[1][1];
            if (isPrime(row0)) {
                compare1 += a; // 소수인 경우 a점
            } else {
                compare1 += b; // 소수가 아닌 경우 b점
            }
            if (isPrime(row1)) {
                compare1 += a; // 소수인 경우 a점
            } else {
                compare1 += b; // 소수가 아닌 경우 b점
            }
            
            total[1] = Math.max(compare0, compare1);
        }
        
        if (n >= 2) {
            System.out.println(calc(board, total, n - 1));            
        } else {
            System.out.println(total[n-1]);
        }
    }

    private static int calc(int[][] board, int[] total, int idx) {
        if (total[idx] != Integer.MIN_VALUE) {
            return total[idx];
        }
        
        // 세로 타일 방식
        int vertical;
        if (isPrime(board[0][idx] + board[1][idx])) {
            vertical = calc(board, total, idx-1) + a; // 소수인 경우 a점
        } else {
            vertical = calc(board, total, idx-1) + b; // 소수가 아닌 경우 b점
        }
        
        // 가로 타일 방식
        int horizontal = calc(board, total, idx-2);
        
        int row1 = board[0][idx-1] + board[0][idx];
        int row2 = board[1][idx-1] + board[1][idx];
        
        if (isPrime(row1)) {
            horizontal += a; // 소수인 경우 a점
        } else {
            horizontal += b; // 소수가 아닌 경우 b점
        }
        
        if (isPrime(row2)) {
            horizontal += a; // 소수인 경우 a점
        } else {
            horizontal += b; // 소수가 아닌 경우 b점
        }
        
        total[idx] = Math.max(vertical, horizontal);
        return total[idx];
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        if (num == 2) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}