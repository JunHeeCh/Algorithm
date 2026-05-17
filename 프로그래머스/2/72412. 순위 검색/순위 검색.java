import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, List<Integer>> map = new HashMap<>();

        // 1. 전처리: 각 지원자의 16가지 조합을 map에 저장
        for (String s : info) {
            String[] t = s.split(" ");
            // [언어, 직군, 경력, 음식, 점수]
            String[] attrs = {t[0], t[1], t[2], t[3]};
            int score = Integer.parseInt(t[4]);

            // 2^4 = 16가지 조합 생성
            for (int i = 0; i < 16; i++) {
                String[] combo = new String[4];
                for (int j = 0; j < 4; j++) {
                    // j번째 비트가 1이면 실제 값, 0이면 "-"
                    combo[j] = (i & (1 << j)) != 0 ? attrs[j] : "-";
                }
                String key = String.join("_", combo);
                map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
            }
        }

        // 2. 각 key의 점수 리스트 오름차순 정렬
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        // 3. 쿼리 처리
        for (int i = 0; i < query.length; i++) {
            String[] t = query[i].split(" and |\\s+");
            // t = [언어, 직군, 경력, 음식, 점수]
            String key = t[0] + "_" + t[1] + "_" + t[2] + "_" + t[3];
            int score = Integer.parseInt(t[4]);

            List<Integer> list = map.get(key);
            if (list == null) {
                answer[i] = 0;
            } else {
                // 이진 탐색: score 이상인 첫 번째 인덱스 찾기
                answer[i] = list.size() - lowerBound(list, score);
            }
        }

        return answer;
    }

    // score 이상인 첫 번째 인덱스 반환 (Lower Bound)
    private int lowerBound(List<Integer> list, int score) {
        int lo = 0, hi = list.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (list.get(mid) < score) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}