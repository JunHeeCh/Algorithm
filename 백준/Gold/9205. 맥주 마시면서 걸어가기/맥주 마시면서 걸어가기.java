import java.io.*;
import java.util.*;

public class Main {

    static int manhattan(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            int[][] p = new int[n + 2][2]; // 0: 집, 1..n: 편의점, n+1: 페스티벌
            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                p[i][0] = Integer.parseInt(st.nextToken());
                p[i][1] = Integer.parseInt(st.nextToken());
            }

            boolean[] visited = new boolean[n + 2];
            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.add(0);
            visited[0] = true;

            boolean ok = false;

            while (!q.isEmpty()) {
                int cur = q.poll();

                if (cur == n + 1) { // 페스티벌 도착
                    ok = true;
                    break;
                }

                for (int nxt = 0; nxt < n + 2; nxt++) {
                    if (!visited[nxt] && manhattan(p[cur], p[nxt]) <= 1000) {
                        visited[nxt] = true;
                        q.add(nxt);
                    }
                }
            }

            sb.append(ok ? "happy\n" : "sad\n");
        }

        System.out.print(sb.toString());
    }
}
