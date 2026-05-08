import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        // 0: 헤드 센티넬, 1~n: 실제 행, n+1: 테일 센티넬
        int[] prev = new int[n + 2];
        int[] next = new int[n + 2];

        // 초기 연결: 0 ↔ 1 ↔ 2 ↔ ... ↔ n ↔ n+1
        for (int i = 0; i <= n + 1; i++) {
            prev[i] = i - 1;
            next[i] = i + 1;
        }

        int cur = k + 1; // 1-indexed로 변환
        Deque<Integer> stack = new ArrayDeque<>();

        for (String c : cmd) {
            char ch = c.charAt(0);

            if (ch == 'U') {
                int x = Integer.parseInt(c.substring(2));
                for (int i = 0; i < x; i++) cur = prev[cur]; // O(x)

            } else if (ch == 'D') {
                int x = Integer.parseInt(c.substring(2));
                for (int i = 0; i < x; i++) cur = next[cur]; // O(x)

            } else if (ch == 'C') {
                stack.push(cur);
                // 포인터만 변경 → O(1)
                next[prev[cur]] = next[cur];
                prev[next[cur]] = prev[cur];
                // 마지막 행이면 위로, 아니면 아래로
                cur = (next[cur] == n + 1) ? prev[cur] : next[cur];

            } else { // Z
                int restored = stack.pop();
                // 저장된 prev/next 그대로 복구 → O(1)
                next[prev[restored]] = restored;
                prev[next[restored]] = restored;
            }
        }

        // 살아있는 노드 표시
        boolean[] deleted = new boolean[n + 2];
        Arrays.fill(deleted, true);
        for (int node = next[0]; node != n + 1; node = next[node]) {
            deleted[node] = false;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(deleted[i] ? 'X' : 'O');
        }
        return sb.toString();
    }
}