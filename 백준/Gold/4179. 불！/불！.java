import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = new int[] { -1, 1, 0, 0 };
    static int[] dc = new int[] { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] temp = br.readLine().trim().split(" ");

        int N = Integer.parseInt(temp[0]);
        int M = Integer.parseInt(temp[1]);

        Queue<int[]> fire = new LinkedList<>();
        Queue<int[]> jihoon = new LinkedList<>();

        int[][] board = new int[N][M]; // 불 도착 시간 기록 (0=불X, -1=벽)
        boolean[][] visited = new boolean[N][M];

        int cnt = 0; // 불 개수

        for (int i = 0; i < N; i++) {
            String[] tmp = br.readLine().trim().split("");
            for (int j = 0; j < M; j++) {
                if (tmp[j].equals("#")) {
                    board[i][j] = -1; // 벽
                } else if (tmp[j].equals("J")) {
                    jihoon.add(new int[] { i, j });
                    visited[i][j] = true;
                    if (i == 0 || i == N - 1 || j == 0 || j == M - 1) {
                        System.out.println("1");
                        return;
                    }
                } else if (tmp[j].equals("F")) {
                    fire.add(new int[] { i, j });
                    board[i][j] = 1; // 불 시작 시간 = 1
                    cnt++;
                }
            }
        }

        // 불 BFS: 각 칸에 불 도착 시간 기록
        while (!fire.isEmpty()) {
            int[] now = fire.poll();
            for (int d = 0; d < 4; d++) {
                int nr = now[0] + dr[d];
                int nc = now[1] + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (board[nr][nc] != 0) continue; // 이미 벽이거나 불이 번짐

                board[nr][nc] = board[now[0]][now[1]] + 1;
                fire.add(new int[] { nr, nc });
            }
        }

        // 지훈 BFS
        int time = 1;
        while (!jihoon.isEmpty()) {
            int size = jihoon.size();
            for (int i = 0; i < size; i++) {
                int[] now = jihoon.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = now[0] + dr[d];
                    int nc = now[1] + dc[d];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                    if (visited[nr][nc] || board[nr][nc] == -1) continue; // 이미 방문했거나 벽

                    // 불보다 늦게 도착하면 이동 불가
                    if (board[nr][nc] != 0 && board[nr][nc] <= time + 1) continue;

                    if (nr == 0 || nr == N - 1 || nc == 0 || nc == M - 1) {
                        System.out.println(time + 1);
                        return;
                    }

                    visited[nr][nc] = true;
                    jihoon.add(new int[] { nr, nc });
                }
            }
            time++;
        }

        System.out.println("IMPOSSIBLE");
    }
}
