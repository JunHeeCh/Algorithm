import java.util.*;

class Solution {

    int answer = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {

        int m = weak.length;

        // weak 간 거리 배열
        int[] arr = new int[m];

        for (int i = 0; i < m - 1; i++) {
            arr[i] = weak[i + 1] - weak[i];
        }

        arr[m - 1] = n - weak[m - 1] + weak[0];

        // 모든 친구 순열 생성
        permute(dist, 0, arr, m);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    void permute(int[] dist, int depth, int[] arr, int m) {

        if (depth == dist.length) {

            // 모든 시작점 시도
            for (int start = 0; start < m; start++) {

                int covered = 0;
                int friendCount = 0;

                for (int f = 0; f < dist.length && covered < m; f++) {

                    friendCount++;

                    int remain = dist[f];

                    // 출발 지점 커버
                    covered++;

                    // 다음 취약지점들 이동
                    while (covered < m) {

                        remain -= arr[(start + covered - 1) % m];

                        if (remain < 0) break;

                        covered++;
                    }
                }

                if (covered >= m) {
                    answer = Math.min(answer, friendCount);
                }
            }

            return;
        }

        // permutation
        for (int i = depth; i < dist.length; i++) {

            swap(dist, depth, i);

            permute(dist, depth + 1, arr, m);

            swap(dist, depth, i);
        }
    }

    void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}