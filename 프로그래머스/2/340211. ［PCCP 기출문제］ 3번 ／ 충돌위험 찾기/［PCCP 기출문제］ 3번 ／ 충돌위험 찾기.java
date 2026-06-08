import java.util.*;

class Solution {

    int answer = 0;

    public int solution(int[][] points, int[][] routes) {
        List<Node> bots = new ArrayList<>();

        for (int[] route : routes) {
            int[][] waypoints = new int[route.length][];
            for (int i = 0; i < route.length; i++) {
                waypoints[i] = points[route[i] - 1];
            }
            bots.add(new Node(waypoints));
        }

        while (bots.stream().anyMatch(b -> !b.fin)) {
            check(bots);
            move(bots);
        }

        return answer;
    }

    public void check(List<Node> bots) {
        int[][] visited = new int[101][101];

        for (Node n : bots) {
            if (n.fin) continue; // fin된 봇은 이미 필드에 없음
            int r = n.now[0], c = n.now[1];
            visited[r][c]++;
            if (visited[r][c] == 2) {
                answer++;
            }
        }
    }

    public void move(List<Node> bots) {
        for (Node n : bots) {
            if (n.fin) continue;

            int[] goal = n.waypoints[n.routeIdx];

            if (n.now[0] != goal[0]) {
                n.now[0] += (n.now[0] < goal[0]) ? 1 : -1;
            } else if (n.now[1] != goal[1]) {
                n.now[1] += (n.now[1] < goal[1]) ? 1 : -1;
            } else {
                // 경유지 도달
                n.routeIdx++;
                if (n.routeIdx >= n.waypoints.length) {
                    n.fin = true; // 다음 check()부터 제외됨
                    continue;
                }
                // 다음 경유지로 이동
                goal = n.waypoints[n.routeIdx];
                if (n.now[0] != goal[0]) {
                    n.now[0] += (n.now[0] < goal[0]) ? 1 : -1;
                } else {
                    n.now[1] += (n.now[1] < goal[1]) ? 1 : -1;
                }
            }
        }
    }
}

class Node {
    int[] now;
    int[][] waypoints;
    int routeIdx;
    boolean fin;

    public Node(int[][] waypoints) {
        this.waypoints = waypoints;
        this.now = waypoints[0].clone();
        this.routeIdx = 1; // 향하는 목적지는 1번부터
        this.fin = (waypoints.length == 1); // 경유지가 시작점 하나뿐이면 즉시 fin
    }
}