import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // DP 테이블: dp[i][j] = i번째부터 j번째까지 팰린드롬인지 여부
        boolean[][] dp = new boolean[N][N];

        // 1. 길이 1인 팰린드롬 (모든 단일 문자는 팰린드롬)
        for (int i = 0; i < N; i++) {
            dp[i][i] = true;
        }

        // 2. 길이 2인 팰린드롬
        for (int i = 0; i < N - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = true;
            }
        }

        // 3. 길이 3 이상인 팰린드롬
        for (int len = 3; len <= N; len++) {          // 길이별로
            for (int i = 0; i <= N - len; i++) {      // 시작점
                int j = i + len - 1;                   // 끝점
                
                // 양 끝이 같고, 가운데 부분이 팰린드롬이면
                if (arr[i] == arr[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        // 질문 처리
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;  // 0-based로 변환
            int e = Integer.parseInt(st.nextToken()) - 1;
            
            sb.append(dp[s][e] ? 1 : 0).append('\n');
        }

        System.out.print(sb);
    }
}