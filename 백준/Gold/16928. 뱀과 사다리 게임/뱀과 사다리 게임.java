import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        int N = Integer.parseInt(temp[0]); // 사다리 개수
        int M = Integer.parseInt(temp[1]); // 뱀 개수

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N + M; i++) { // 🔹 입력 개수 수정
            temp = br.readLine().split(" ");
            int s = Integer.parseInt(temp[0]);
            int e = Integer.parseInt(temp[1]);
            map.put(s, e);
        }

        boolean[] visited = new boolean[101];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0}); // 시작 위치 (칸, 주사위 횟수)
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int pos = now[0];
            int cnt = now[1];

            if (pos == 100) {
                System.out.println(cnt);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int next = pos + i;
                if (next > 100) continue;

                if (map.containsKey(next)) {
                    next = map.get(next); // 사다리나 뱀 이동
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, cnt + 1});
                }
            }
        }
    }
}
