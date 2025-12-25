import java.util.*;

class Solution {
    public String solution(String number, int k) {
        char[] arr = number.toCharArray();
        char[] stack = new char[arr.length];
        int top = 0; // stack size

        for (char c : arr) {
            while (k > 0 && top > 0 && stack[top - 1] < c) {
                top--;
                k--;
            }
            stack[top++] = c;
        }

        // 아직 k가 남아있다면 뒤에서 제거
        top -= k;

        return new String(stack, 0, top);
    }
}
