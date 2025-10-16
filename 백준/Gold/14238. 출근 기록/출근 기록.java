import java.util.*;
import java.io.*;

public class Main {
    static String answer;
    static Boolean[][][][][] dp; // dp[a][b][c][prev1][prev2]

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] S = br.readLine().trim().toCharArray();
        int[] arr = new int[3];

        for (int i = 0; i < S.length; i++) {
            if (S[i] == 'A') arr[0]++;
            else if (S[i] == 'B') arr[1]++;
            else arr[2]++;
        }

        answer = "";
        // prev를 3으로 초기화 = "아직 아무것도 안 놓음"
        dp = new Boolean[arr[0]+1][arr[1]+1][arr[2]+1][4][4];

        if (solve(arr[0], arr[1], arr[2], 3, 3, new StringBuilder())) {
            System.out.println(answer);
        } else {
            System.out.println("-1");
        }
    }

    static boolean solve(int a, int b, int c, int prev1, int prev2, StringBuilder sb) {
        // 이미 답을 찾았으면 종료
        if (!answer.isEmpty()) {
            return true;
        }

        // 종료 조건: 모든 문자를 다 사용
        if (a == 0 && b == 0 && c == 0) {
            answer = sb.toString();
            return true;
        }

        // 메모이제이션 확인 - 이 상태를 이미 계산했으면 재사용
        if (dp[a][b][c][prev1][prev2] != null) {
            return dp[a][b][c][prev1][prev2];
        }

        boolean result = false;

        // C 배치 시도 (직전 2개가 C가 아닐 때)
        if (c > 0 && prev1 != 2 && prev2 != 2) {
            sb.append('C');
            if (solve(a, b, c-1, 2, prev1, sb)) {
                result = true;
            }
            sb.deleteCharAt(sb.length() - 1);
            if (result) {
                dp[a][b][c][prev1][prev2] = true;
                return true;
            }
        }

        // B 배치 시도 (직전이 B가 아닐 때)
        if (b > 0 && prev1 != 1) {
            sb.append('B');
            if (solve(a, b-1, c, 1, prev1, sb)) {
                result = true;
            }
            sb.deleteCharAt(sb.length() - 1);
            if (result) {
                dp[a][b][c][prev1][prev2] = true;
                return true;
            }
        }

        // A 배치 시도 (항상 가능)
        if (a > 0) {
            sb.append('A');
            if (solve(a-1, b, c, 0, prev1, sb)) {
                result = true;
            }
            sb.deleteCharAt(sb.length() - 1);
            if (result) {
                dp[a][b][c][prev1][prev2] = true;
                return true;
            }
        }

        // 모든 시도가 실패
        dp[a][b][c][prev1][prev2] = false;
        return false;
    }
}