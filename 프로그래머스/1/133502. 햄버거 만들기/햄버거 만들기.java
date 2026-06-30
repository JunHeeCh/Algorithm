import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int x : ingredient) {
            stack.push(x);
            // 맨 위가 ... 1,2,3,1 순서인지 확인
            if (stack.size() >= 4 && x == 1) {
                Iterator<Integer> it = stack.iterator();
                if (it.next() == 1 && it.next() == 3 && it.next() == 2 && it.next() == 1) {
                    for (int i = 0; i < 4; i++) stack.pop();
                    answer++;
                }
            }
        }
        return answer;
    }
}