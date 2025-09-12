import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        // dp[i] = i개의 돌에서 게임을 시작할 때 이기는 사람 (1: 상근, 2: 창영)
        int[] dp = new int[N + 1];
        
        // 기저 조건
        dp[1] = 1; // 상근이가 1개 가져가서 이김
        if (N >= 2) dp[2] = 2; // 상근이가 1개 가져가면 창영이가 1개 가져가서 이김
        if (N >= 3) dp[3] = 1; // 상근이가 3개 가져가서 이김
        
        for (int i = 4; i <= N; i++) {
            // 현재 턴인 사람이 1개 또는 3개를 가져갈 수 있음
            // 상대방이 지게 되는 선택이 있으면 그 선택을 함
            if (dp[i-1] == 2 || dp[i-3] == 2) {
                dp[i] = 1; // 첫 번째 플레이어가 이김
            } else {
                dp[i] = 2; // 두 번째 플레이어가 이김
            }
        }
        
        if (dp[N] == 1) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}