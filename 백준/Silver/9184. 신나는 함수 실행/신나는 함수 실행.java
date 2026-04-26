import java.io.*;
import java.util.*;

public class Main {

    static int[][][] dp = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1)
                break;

            sb.append("w(" + a + ", " + b + ", " + c + ") = ");
            sb.append(find(a, b, c)).append("\n");
        }

        System.out.print(sb);
    }

    static int find(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0)
            return 1;

        if (a > 20 || b > 20 || c > 20)
            return find(20, 20, 20);

        if (dp[a][b][c] != 0)
            return dp[a][b][c];

        if (a < b && b < c) {
            return dp[a][b][c] =
                    find(a, b, c - 1)
                  + find(a, b - 1, c - 1)
                  - find(a, b - 1, c);
        }

        return dp[a][b][c] =
                find(a - 1, b, c)
              + find(a - 1, b - 1, c)
              + find(a - 1, b, c - 1)
              - find(a - 1, b - 1, c - 1);
    }
}