import java.util.*;

class Solution {

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        List<node> list = new ArrayList<>();
        for (int i = 0; i < routes.length; i++) {
            int[] start = points[routes[i][0] - 1].clone();
            list.add(new node(start, routes[i]));
        }

        answer += check(list);

        while (list.size() > 0) {
            move(list, points);
            answer += check(list);
        }
        return answer;
    }

    public void move(List<node> list, int[][] points) {
        for (int i = 0; i < list.size(); i++) {
            node cur = list.get(i);
            int[] target = points[cur.route[cur.idx] - 1];

            if (cur.now[0] == target[0] && cur.now[1] == target[1]) {
                cur.idx++;
                if (cur.idx == cur.route.length) {
                    list.remove(i);
                    i--;
                    continue;
                }
                target = points[cur.route[cur.idx] - 1];
            }
            if (cur.now[0] != target[0]) {
                if (cur.now[0] > target[0]) {
                    cur.now[0]--;
                } else {
                    cur.now[0]++;
                }
            } else {
                if (cur.now[1] > target[1]) {
                    cur.now[1]--;
                } else {
                    cur.now[1]++;
                }
            }
        }
    }

    public int check(List<node> list) {
        int answer = 0;
        int[][] board = new int[101][101];
        for (node n : list) {
            if (board[n.now[0]][n.now[1]] == 1) {
                answer++;
            }
            board[n.now[0]][n.now[1]]++;
        }
        return answer;
    }
}

class node {
    int[] now;
    int[] route;
    int idx;

    public node(int[] now, int[] route) {
        this.now = now;
        this.route = route;
        this.idx = 1;   
    }
}