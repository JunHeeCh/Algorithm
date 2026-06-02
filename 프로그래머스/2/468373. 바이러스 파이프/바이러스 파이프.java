import java.util.*;

class Solution {
    List<int[]>[] list;
    int n, answer = 0;

    public int solution(int n, int infection, int[][] edges, int k) {
        this.n = n;
        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) list[i] = new ArrayList<>();

        for (int[] e : edges) {
            list[e[0]].add(new int[]{e[1], e[2]});
            list[e[1]].add(new int[]{e[0], e[2]});
        }

        // 초기 감염 노드 집합
        Set<Integer> infected = new HashSet<>();
        infected.add(infection);

        // k번 선택 순서를 완전 탐색
        dfs(infected, k, 0);
        return answer;
    }

    void dfs(Set<Integer> infected, int k, int depth) {
        answer = Math.max(answer, infected.size());
        if (depth == k) return;

        for (int type = 1; type <= 3; type++) {
            // 현재 감염 노드에서 type 파이프를 열었을 때 새로 감염되는 노드 BFS
            Set<Integer> newInfected = spread(infected, type);
            if (newInfected.size() == infected.size()) continue; // 변화 없으면 skip
            dfs(newInfected, k, depth + 1);
        }
    }

    Set<Integer> spread(Set<Integer> infected, int type) {
        Set<Integer> result = new HashSet<>(infected);
        Queue<Integer> queue = new LinkedList<>(infected);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int[] next : list[cur]) {
                if (next[1] == type && !result.contains(next[0])) {
                    result.add(next[0]);
                    queue.add(next[0]);
                }
            }
        }
        return result;
    }
}